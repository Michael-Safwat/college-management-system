package com.michael.college_management_system.security;

import com.michael.college_management_system.helpers.Result;
import com.michael.college_management_system.helpers.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Result getLoginInfo(Authentication authentication) {
        log.debug("Authenticated user: '{}'", authentication.getName());
        return new Result(true, StatusCode.SUCCESS, "User info and JWT", this.authService.createLoginInfo(authentication));
    }
}
