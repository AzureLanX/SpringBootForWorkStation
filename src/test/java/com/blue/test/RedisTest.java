package com.blue.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.test
 * @Author: JuferBlue
 * @CreateTime: 2025-01-06  20:48
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("name","blue");
        System.out.println("测试成功");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
