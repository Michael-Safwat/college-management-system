package com.michael.college_management_system.service;

import com.michael.college_management_system.dto.CourseDTO;
import com.michael.college_management_system.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<CourseDTO> getCourseById(Long courseId) {

        return null;
    }
}
