package com.michael.college_management_system.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<StudentDTO> registerStudent(@RequestBody Student student) {
        return new ResponseEntity<>(this.studentService.registerStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getAllStudents
            (@RequestParam(value = "page", required = false) Integer page,
             @RequestParam(value = "size", required = false) Integer size,
             @RequestParam(value = "isGraduate", required = false) Boolean isGraduate,
             @RequestParam(value = "topStudents", required = false) Boolean topStudents,
             @PageableDefault(page = 0, size = 10) Pageable pageableDefault) {
        int actualPage = (page == null) ? pageableDefault.getPageNumber() : page;
        int actualSize = (size == null) ? pageableDefault.getPageSize() : size;
        PageRequest pageRequest;
        if (topStudents != null && topStudents)
            pageRequest = PageRequest.of(0, actualSize, Sort.by(Sort.Direction.DESC, "gpa"));
        else
            pageRequest = PageRequest.of(actualPage, actualSize);
        return new ResponseEntity<>(studentService.getAllStudents(pageRequest, isGraduate), HttpStatus.OK);
    }

    @GetMapping("/topByDepartment")
    public ResponseEntity<List<StudentDTO>> getTopStudentsByDepartment(
            @RequestParam(value = "department", required = true) Department department,
            @RequestParam(value = "limit", defaultValue = "3") int limit
    ) {
        return new ResponseEntity<>(studentService.getTopStudentsByDepartment(department, limit), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Long studentId, Authentication authentication) {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentService.removeStudentById(studentId), HttpStatus.NO_CONTENT);
    }


}
