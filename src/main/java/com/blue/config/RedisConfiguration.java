package com.blue.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.config
 * @Author: JuferBlue
 * @CreateTime: 2025-01-06  20:46
 * @Description: Redis 配置类
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redisTemplate对象...");
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置redis连接工厂对象
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置key的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化器（默认使用 JDK 序列化）
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        log.info("创建成功redisTemplate对象");
        return redisTemplate;
    }
}
