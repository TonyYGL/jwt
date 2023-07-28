package com.tutorabc.jwt.aspect;

import com.tutorabc.jwt.service.JwtService;
import com.tutorabc.jwt.service.SettingService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class JwtAspect {

    @Autowired
    private SettingService settingService;
    @Autowired
    private JwtService jwtService;


    @Before("@annotation(com.tutorabc.jwt.annotation.JwtTokenRequire)") // 使用自定义注解标记需要验证Token的方法
    public void verifyJwtToken(JoinPoint joinPoint) throws Throwable {

        String jwtSalt = settingService.findJwtSalt();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // 这里可以对HttpServletRequest对象进行操作，例如获取请求参数、请求头等信息
        String jwtToken = request.getHeader("Authorization");
        if (jwtToken == null) {
            throw new RuntimeException("JWT Token is missing"); // 或者抛出其他异常
        }

        try {
            jwtService.isTokenValid(jwtToken);
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("JWT Token has expired"); // 或者抛出其他异常
        } catch (JwtException e) {
            throw new RuntimeException("Invalid JWT Token"); // 或者抛出其他异常
        }
    }


}
