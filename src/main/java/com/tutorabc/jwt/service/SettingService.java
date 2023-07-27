package com.tutorabc.jwt.service;

import com.tutorabc.jwt.entity.Setting;
import com.tutorabc.jwt.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    private static final String JWT_SALT_KEY = "jwtSalt";

    @Autowired
    private SettingRepository settingRepository;

    // TODO 配置Ehcache
    @Cacheable(value = "jwtSaltCache")
    public String findJwtSalt() {
        Setting setting = settingRepository.findBySettingKey(JWT_SALT_KEY);
        if (setting == null) {
            throw new RuntimeException("jwt salt setting not found");
        }
        return setting.getSettingValue();
    }
}
