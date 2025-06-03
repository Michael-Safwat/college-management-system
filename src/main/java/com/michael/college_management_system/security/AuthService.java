package com.michael.college_management_system.security;

import com.michael.college_management_system.dto.StudentDTO;
import com.michael.college_management_system.helpers.mapper.StudentMapper;
import com.michael.college_management_system.model.Student;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JWTProvider jwtProvider;

    public AuthService(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public Map<String, Object> createLoginInfo(Authentication authentication) {
        //create user info
        StudentPrincipal principal = (StudentPrincipal) authentication.getPrincipal();
        Student student = principal.getStudent();
        StudentDTO studentDTO = StudentMapper.toStudentDTO(student);

        //create JWT
        String token = this.jwtProvider.createToken(authentication);

        Map<String, Object> loginResultMap = new HashMap<>();
        loginResultMap.put("studentInfo", studentDTO);
        loginResultMap.put("token", token);

        return loginResultMap;
    }
}
