package com.tutorabc.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void addToRedis(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getFromRedis(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void deleteFromRedis(String key) {
        stringRedisTemplate.delete(key);
    }

}
