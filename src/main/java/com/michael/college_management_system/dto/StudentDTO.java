package com.michael.college_management_system.dto;

import com.michael.college_management_system.model.Department;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    private String username;
    private String roles;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private LocalDate graduationDate;
    private Double gpa;
    private Department department;
}
