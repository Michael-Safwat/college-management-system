package com.michael.college_management_system.Controller;

import com.michael.college_management_system.dto.StudentDTO;
import com.michael.college_management_system.model.Student;
import com.michael.college_management_system.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(this.studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Long studentId) {

        return studentService.getStudentById(studentId);
    }
}
