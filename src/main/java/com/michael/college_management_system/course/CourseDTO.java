package com.michael.college_management_system.course;

import com.michael.college_management_system.student.Student;
import lombok.*;

import java.time.Year;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String name;
    private String instructorName;
    private Year year;
    private List<Student> students;
}
