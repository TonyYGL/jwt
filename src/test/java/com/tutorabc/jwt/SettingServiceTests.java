package com.tutorabc.jwt;

import com.tutorabc.jwt.service.SettingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SettingServiceTests {

    @Autowired
    private SettingService settingService;

    @Test
    public void findJwtSalt_test() {
        Assert.assertEquals("we465qdQD", settingService.findJwtSalt());
    }
}
