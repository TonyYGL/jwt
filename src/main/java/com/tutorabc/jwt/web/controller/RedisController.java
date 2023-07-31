package com.tutorabc.jwt.web.controller;

import com.tutorabc.jwt.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/{key}")
    public String getFromRedis(@PathVariable String key) {
        return redisService.getFromRedis(key);
    }

    @PostMapping
    public void addToRedis(@RequestParam("key") String key,
                     @RequestParam("value") String value) {
        redisService.addToRedis(key, value);
    }

    @DeleteMapping
    public void deleteFromRedis(@RequestParam("key") String key) {
        redisService.deleteFromRedis(key);
    }
}
