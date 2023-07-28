package com.tutorabc.jwt.web.controller;

import com.alibaba.fastjson.JSON;
import com.tutorabc.jwt.service.JwtService;
import com.tutorabc.jwt.service.LoginService;
import com.tutorabc.jwt.web.request.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginController(JwtService jwtService, LoginService loginService) {
        this.jwtService = jwtService;
        this.loginService = loginService;
    }

    private JwtService jwtService;
    private LoginService loginService;

    Logger LOG = LoggerFactory.getLogger("LoginController");

    @PostMapping("/login")
    public String login(@RequestBody UserLogin userLogin) {
        LOG.info("/login request: {}", JSON.toJSONString(userLogin));
        return loginService.login(userLogin);
    }

    @PostMapping("/validate")
    public String validateToken(@RequestParam String token) {
        if (jwtService.isTokenValid(token)) {
            return jwtService.getUsernameFromToken(token);
        }
        return "validate jwt token error";
    }
}
