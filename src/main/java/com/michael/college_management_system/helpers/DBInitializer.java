package com.michael.college_management_system.helpers;

import com.michael.college_management_system.model.Admin;
import com.michael.college_management_system.model.Department;
import com.michael.college_management_system.model.Student;
import com.michael.college_management_system.service.AdminService;
import com.michael.college_management_system.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBInitializer implements CommandLineRunner {

    private final StudentService studentService;
    private final AdminService adminService;

    public DBInitializer(StudentService studentService, AdminService adminService) {
        this.studentService = studentService;
        this.adminService = adminService;
    }


    @Override
    public void run(String... args) throws Exception {

        Student student1 = Student.builder()
                .name("Michael")
                .username("mike")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(2.9)
                .department(Department.CS)
                .build();

        Student student2 = Student.builder()
                .name("John")
                .username("john")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2022, 9, 25))
                .dateOfBirth(LocalDate.of(2004, 10, 25))
                .graduationDate(LocalDate.of(2026, 7, 30))
                .gpa(3.9)
                .department(Department.IS)
                .build();

        Student student3 = Student.builder()
                .name("Mark")
                .username("mark")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(2.8)
                .department(Department.CS)
                .build();

        Student student4 = Student.builder()
                .name("Luke")
                .username("luke")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2019, 9, 25))
                .dateOfBirth(LocalDate.of(2001, 10, 25))
                .graduationDate(LocalDate.of(2023, 7, 30))
                .gpa(3.2)
                .department(Department.IT)
                .build();

        Student student5 = Student.builder()
                .name("Noah")
                .username("noah")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(3.1)
                .department(Department.CS)
                .build();

        Student student6 = Student.builder()
                .name("Jennie")
                .username("jenn")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2022, 9, 25))
                .dateOfBirth(LocalDate.of(2004, 10, 25))
                .graduationDate(LocalDate.of(2026, 7, 30))
                .gpa(2.8)
                .department(Department.CS)
                .build();

        Student student7 = Student.builder()
                .name("Emilia")
                .username("emmie")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2018, 9, 25))
                .dateOfBirth(LocalDate.of(2000, 10, 25))
                .graduationDate(LocalDate.of(2022, 7, 30))
                .gpa(2.7)
                .department(Department.IT)
                .build();

        Student student8 = Student.builder()
                .name("Mary")
                .username("mary")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(3.3)
                .department(Department.IS)
                .build();

        Student student9 = Student.builder()
                .name("Mathew")
                .username("mathew")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(3.0)
                .department(Department.IS)
                .build();

        Student student10 = Student.builder()
                .name("James")
                .username("james")
                .password("123")
                .roles("student")
                .joiningDate(LocalDate.of(2020, 9, 25))
                .dateOfBirth(LocalDate.of(2002, 10, 25))
                .graduationDate(LocalDate.of(2024, 7, 30))
                .gpa(4.0)
                .department(Department.CS)
                .build();

        Admin admin = Admin.builder()
                .name("Shery")
                .username("sher")
                .password("123")
                .NID("9999999")
                .roles("admin")
                .build();

        this.studentService.registerStudent(student1);
        this.studentService.registerStudent(student2);
        this.studentService.registerStudent(student3);
        this.studentService.registerStudent(student4);
        this.studentService.registerStudent(student5);
        this.studentService.registerStudent(student6);
        this.studentService.registerStudent(student7);
        this.studentService.registerStudent(student8);
        this.studentService.registerStudent(student9);
        this.studentService.registerStudent(student10);
        this.adminService.registerAdmin(admin);
    }
}
