package com.example.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
	@Bean
	public ObjectMapper getObjectMapper(){
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("我开始执行了 ");
		//注释掉 {"userName":"shiming","age":26,"password":"123456","birthday":1537941171632}
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return mapper;
	}
}
