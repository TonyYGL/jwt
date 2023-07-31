package com.tutorabc.jwt.service;

import com.tutorabc.jwt.web.request.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    LoginService(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    /**
     * success => return jwt token
     * fail => return empty string
     * */
    public String login(UserLogin userLogin) {
        if (userService.isValidUser(userLogin)) {
            return jwtService.generateToken(userLogin.getUsername());
        }
        return "";
    }
}
