package com.whenling.module.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfiguration {

	@Value("${redis.host?:120.25.241.144}")
	private String hostName;

	@Value("${redis.port?:6379}")
	private String port;

	@Value("${redis.password?:b840fc02d52404542994}")
	private String password;

	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		return config;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(jedisPoolConfig());
		connectionFactory.setHostName(hostName);
		connectionFactory.setPort(Integer.parseInt(port));
		connectionFactory.setPassword(password);
		return connectionFactory;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisConnectionFactory());
		return stringRedisTemplate;
	}
}
