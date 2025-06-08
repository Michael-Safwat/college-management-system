package com.michael.college_management_system.student;

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
                .department(student.getDepartment().name())
                .build();
    }
}
