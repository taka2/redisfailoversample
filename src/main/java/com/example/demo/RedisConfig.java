package com.example.demo;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

	@Bean
	public RedisConnectionFactory lettuceConnectionFactory() {
	  RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
	  .master("mymaster")
	  .sentinel("172.30.2.184", 26379)
	  .sentinel("172.30.2.184", 26380);
	  
	  //LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder().commandTimeout(Duration.of(20, ChronoUnit.SECONDS)).build();
	  //return new LettuceConnectionFactory(sentinelConfig, clientConfig);
	  
	  return new LettuceConnectionFactory(sentinelConfig);
	}

}
