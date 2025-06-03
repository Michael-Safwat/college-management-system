package com.michael.college_management_system.helpers.mapper;

import com.michael.college_management_system.dto.StudentDTO;
import com.michael.college_management_system.model.Student;

public class StudentMapper {

    public static StudentDTO toStudentDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .username(student.getUsername())
                .roles(student.getRoles())
                .dateOfBirth(student.getDateOfBirth())
                .gpa(student.getGpa())
                .joiningDate(student.getJoiningDate())
                .graduationDate(student.getGraduationDate())
                .department(student.getDepartment())
                .build();
    }
}
