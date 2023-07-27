package com.tutorabc.jwt.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private SettingService settingService;

    private static final long JWT_EXPIRATION_TIME = 60 * 1000; // 一分鐘

    @Autowired
    public JwtService(SettingService settingService) {
        this.settingService = settingService;
    }

    public String generateToken(String username) {

        String jwtSalt = settingService.findJwtSalt();

        Date expirationDate = new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME);

        JwtBuilder jwtBuilder = Jwts.builder()
                .claim("username", username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, jwtSalt);
        return jwtBuilder.compact();
    }

    public String getUsernameFromToken(String token) {

        String jwtSalt = settingService.findJwtSalt();

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSalt)
                .parseClaimsJws(token)
                .getBody();

        return claims.get("username", String.class);
    }


    public boolean isTokenValid(String token) {
        String jwtSalt = settingService.findJwtSalt();
        try {
            Date expirationDate = Jwts.parser()
                    .setSigningKey(jwtSalt)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expirationDate.after(new Date());
        } catch (JwtException e) {
            return false;
        }
    }

}
