package com.michael.college_management_system.service;

import com.michael.college_management_system.dto.StudentDTO;
import com.michael.college_management_system.helpers.mapper.StudentMapper;
import com.michael.college_management_system.model.Student;
import com.michael.college_management_system.repository.StudentRepository;
import com.michael.college_management_system.security.StudentPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public ResponseEntity<StudentDTO> getStudentById(Long studentId) {

        return null;
//        studentRepository.findById(studentId);
    }

    public StudentDTO createStudent(Student student) {
        student.setPassword(this.passwordEncoder.encode(student.getPassword()));
        Student savedStudent = this.studentRepository.save(student);
        return StudentMapper.toStudentDTO(savedStudent);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.studentRepository.findByUsername(username)
                .map(student -> new StudentPrincipal(student))
                .orElseThrow(() -> new UsernameNotFoundException("username " + username + " is not found."));
    }
}
