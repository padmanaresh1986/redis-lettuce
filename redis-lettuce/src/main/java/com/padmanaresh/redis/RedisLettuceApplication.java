package com.padmanaresh.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;

@SpringBootApplication
public class RedisLettuceApplication implements ApplicationRunner {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RedisLettuceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		final Set<String> keys = stringRedisTemplate.keys("*");
		log.info("Existing keys are " + keys);
	}
}
