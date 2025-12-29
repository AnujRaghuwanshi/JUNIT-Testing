package com.example.CRUDApplication.Service.Implementation;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    @Disabled
    public void testConnection() {
        redisTemplate.opsForValue().set("connection-test", "OK");
        String value = redisTemplate.opsForValue().get("connection-test");
        System.out.println("Redis test value = " + value);
    }
}
