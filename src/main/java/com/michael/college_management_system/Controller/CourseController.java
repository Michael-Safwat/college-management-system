package com.michael.college_management_system.Controller;

import com.michael.college_management_system.dto.CourseDTO;
import com.michael.college_management_system.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("courseId") Long courseId) {

        return courseService.getCourseById(courseId);
    }
}
