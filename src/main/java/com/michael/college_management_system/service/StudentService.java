package com.michael.college_management_system.service;

import com.michael.college_management_system.dto.StudentDTO;
import com.michael.college_management_system.helpers.mapper.StudentMapper;
import com.michael.college_management_system.model.Department;
import com.michael.college_management_system.model.Student;
import com.michael.college_management_system.repository.StudentRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public StudentDTO registerStudent(Student student) {
        student.setPassword(this.passwordEncoder.encode(student.getPassword()));
        Student savedStudent = this.studentRepository.save(student);
        return StudentMapper.toStudentDTO(savedStudent);
    }

    public Page<StudentDTO> getAllStudents(Pageable pageable, Boolean isGraduate) {
        Specification<Student> spec = (root, query, criteriaBuilder) -> {
            if (isGraduate == null) {
                // If isGraduate is not provided, no filter applied for graduation status
                return criteriaBuilder.conjunction();
            } else if (isGraduate) {
                // If isGraduate is true: filter for students who have a graduation date
                // and whose graduation date is on or before today
                Predicate hasGraduationDate = criteriaBuilder.isNotNull(root.get("graduationDate"));
                Predicate graduatedByToday = criteriaBuilder.lessThanOrEqualTo(root.get("graduationDate"), LocalDate.now());
                return criteriaBuilder.and(hasGraduationDate, graduatedByToday);
            } else { // isGraduate is false
                // If isGraduate is false: filter for students who do NOT have a graduation date (null)
                // OR whose graduation date is in the future
                Predicate noGraduationDate = criteriaBuilder.isNull(root.get("graduationDate"));
                Predicate futureGraduationDate = criteriaBuilder.greaterThan(root.get("graduationDate"), LocalDate.now());
                return criteriaBuilder.or(noGraduationDate, futureGraduationDate);
            }
        };

        Page<Student> students = studentRepository.findAll(spec, pageable);
        return students.map(StudentMapper::toStudentDTO);
    }

    @PostFilter("filterObject.department == #department.name()")
    public List<StudentDTO> getTopStudentsByDepartment(Department department, int limit) {

        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "gpa"));
        return studentRepository.findAll(pageable).stream()
                .map(StudentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long studentId) {

        Optional<Student> student = this.studentRepository.findById(studentId);
        return student.map(StudentMapper::toStudentDTO).orElse(null);
    }

    public Void removeStudentById(Long studentId) {
        this.studentRepository.deleteById(studentId);
        return null;
    }
}
