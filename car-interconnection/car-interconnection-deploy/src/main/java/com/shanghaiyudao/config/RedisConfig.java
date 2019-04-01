package com.shanghaiyudao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @auther: fjq
 * @2019/3/27 12:47
 * @description: redis相关配置
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, Object> jsonRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
