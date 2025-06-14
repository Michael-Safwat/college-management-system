package com.michael.college_management_system.admin;

public class AdminMapper {

    public static AdminDTO toAdminDTO(Admin admin) {
        return AdminDTO.builder()
                .id(admin.getId())
                .name(admin.getName())
                .username(admin.getUsername())
                .roles(admin.getRoles())
                .build();
    }
}
