package com.michael.college_management_system.helpers;

import com.michael.college_management_system.model.Department;
import com.michael.college_management_system.model.Student;
import com.michael.college_management_system.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBInitializer implements CommandLineRunner {

    private final StudentService studentService;

    public DBInitializer(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public void run(String... args) throws Exception {

        Student student = Student.builder()
                .name("Michael")
                .username("mike")
                .password("123")
                .roles("ROLE_student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(2.9)
                .department(Department.CS)
                .build();

        this.studentService.createStudent(student);
    }
}
