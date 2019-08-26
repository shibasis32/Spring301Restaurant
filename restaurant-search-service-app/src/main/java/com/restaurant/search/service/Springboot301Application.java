package com.restaurant.search.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Springboot301Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot301Application.class, args);
	}

}
