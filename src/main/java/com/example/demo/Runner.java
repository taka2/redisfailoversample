package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	LettuceConnectionFactory factory;
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			redisTemplate.opsForValue().set("key", "value");
			System.out.println("operation succeeded.");
			System.out.println("Connection timeout = " + factory.getTimeout());
			System.out.println("Command timeout = " + factory.getClientConfiguration().getCommandTimeout());
			Thread.sleep(5000);
		}
	}
}
