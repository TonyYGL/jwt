package com.tutorabc.jwt.service;

import com.tutorabc.jwt.entity.Setting;
import com.tutorabc.jwt.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    private static final String JWT_SALT_KEY = "jwtSalt";
    private static final String JWT_EXPIRATION_TIME = "jwtExpirationTime"; // 設定一小時

    @Autowired
    private SettingRepository settingRepository;

    @Cacheable(value = "jwtSaltCache")
    public String findJwtSalt() {
        Setting setting = settingRepository.findBySettingKey(JWT_SALT_KEY);
        if (setting == null) {
            throw new RuntimeException("jwt salt setting not found");
        }
        return setting.getSettingValue();
    }

    @Cacheable(value = "jwtExpirationTimeCache")
    public String findJwtExpirationTime() {
        Setting setting = settingRepository.findBySettingKey(JWT_EXPIRATION_TIME);
        if (setting == null) {
            throw new RuntimeException("jwt expiration time setting not found");
        }
        return setting.getSettingValue();
    }
}
