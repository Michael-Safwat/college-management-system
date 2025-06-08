package com.michael.college_management_system.admin;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private Long id;

    private String username;
    private String name;
    private String roles;
}
