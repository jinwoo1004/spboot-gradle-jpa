package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		System.out.println("APPLICATION START");
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.run();
	}
}