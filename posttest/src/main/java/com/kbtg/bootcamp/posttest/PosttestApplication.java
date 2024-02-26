package com.kbtg.bootcamp.posttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PosttestApplication {
	public static void main(String[] args) {
		SpringApplication.run(PosttestApplication.class, args);
	}

//	@Bean
//	public SQLService sqlService() {
//		return new PostgresSQLService postgresSQLService();
//	}
}
