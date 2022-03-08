package com.reto.tecnico.apiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiUsersApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsersApplication.class);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiUsersApplication.class);
	}
}