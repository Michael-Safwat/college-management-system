package com.michael.college_management_system.Controller;

import com.michael.college_management_system.dto.AdminDTO;
import com.michael.college_management_system.model.Admin;
import com.michael.college_management_system.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<AdminDTO> registerAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.registerAdmin(admin), HttpStatus.CREATED);
    }
}
