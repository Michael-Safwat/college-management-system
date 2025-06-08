package com.michael.college_management_system.security;

import com.michael.college_management_system.admin.AdminDTO;
import com.michael.college_management_system.student.StudentDTO;
import com.michael.college_management_system.admin.AdminMapper;
import com.michael.college_management_system.student.StudentMapper;
import com.michael.college_management_system.admin.Admin;
import com.michael.college_management_system.student.Student;
import com.michael.college_management_system.user.User;
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
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        User user = principal.getUser();

        //create JWT
        Map<String, Object> loginResultMap = new HashMap<>();

        if (user.getRoles().equals("student")) {
            StudentDTO studentDTO = StudentMapper.toStudentDTO((Student) user);
            String token = this.jwtProvider.createToken(authentication);

            loginResultMap.put("studentInfo", studentDTO);
            loginResultMap.put("token", token);
        } else if (user.getRoles().equals("admin")) {
            AdminDTO adminDTO = AdminMapper.toAdminDTO((Admin) user);
            String token = this.jwtProvider.createToken(authentication);

            loginResultMap.put("studentInfo", adminDTO);
            loginResultMap.put("token", token);
        }

        return loginResultMap;
    }
}
