package com.tutorabc.jwt;

import com.tutorabc.jwt.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void findByUsernamePassword_test() {
        Assert.assertEquals("tony", userService.findByUsernamePassword("tony", "tony123").get(0).getUsername());
    }
}
