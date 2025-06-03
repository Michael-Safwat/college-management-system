package com.michael.college_management_system.security;

import com.michael.college_management_system.dto.AdminDTO;
import com.michael.college_management_system.dto.StudentDTO;
import com.michael.college_management_system.helpers.mapper.AdminMapper;
import com.michael.college_management_system.helpers.mapper.StudentMapper;
import com.michael.college_management_system.model.Admin;
import com.michael.college_management_system.model.Student;
import com.michael.college_management_system.model.User;
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

        if(user.getRoles().equals("ROLE_student")){
            StudentDTO studentDTO = StudentMapper.toStudentDTO((Student) user);
            String token = this.jwtProvider.createToken(authentication);

            loginResultMap.put("studentInfo", studentDTO);
            loginResultMap.put("token", token);
        }
        else if(user.getRoles().equals("ROLE_admin")){
            AdminDTO adminDTO = AdminMapper.toAdminDTO((Admin) user);
            String token = this.jwtProvider.createToken(authentication);

            loginResultMap.put("studentInfo", adminDTO);
            loginResultMap.put("token", token);
        }

        return loginResultMap;
    }
}
