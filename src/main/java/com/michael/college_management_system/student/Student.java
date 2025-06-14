package com.michael.college_management_system.student;

import com.michael.college_management_system.course.Course;
import com.michael.college_management_system.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Student extends User {


    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private LocalDate graduationDate;
    private Double gpa;
    @Enumerated(EnumType.STRING)
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}
