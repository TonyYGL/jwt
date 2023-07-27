package com.tutorabc.jwt.web.request;

import lombok.Data;

@Data
public class UserLogin {
    private String username;
    private String password;
}
