package com.michael.college_management_system.course;

import com.michael.college_management_system.student.Department;
import com.michael.college_management_system.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.Year;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(generator = "CourseUUID")
    @GenericGenerator(name = "CourseUUID", type = CourseIdGenerator.class)
    private String id;

    private String name;
    private String instructorName;
    private Year year;
    private Department department;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
