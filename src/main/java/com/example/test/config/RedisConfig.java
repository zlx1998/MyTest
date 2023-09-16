package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author zlx
 * @date 2022/8/25 16:17
 */
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);
		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
		redisTemplate.setDefaultSerializer(serializer);
		redisTemplate.setKeySerializer(serializer);
		redisTemplate.setValueSerializer(serializer);
		redisTemplate.setHashKeySerializer(serializer);
		redisTemplate.setHashValueSerializer(serializer);
		return redisTemplate;
	}

//	@Bean
//	public RedissonClient redissonClient() {
//		Config config = new Config();
//		config.useSingleServer().setAddress("redis://127.0.0.1:6379")
//				.setPassword("123456");
//		RedissonClient redissonClient = Redisson.create(config);
//		return redissonClient;
//	}
}
