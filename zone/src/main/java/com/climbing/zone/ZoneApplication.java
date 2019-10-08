package com.climbing.zone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// modification pour le docker de public class ZoneApplication extends SpringBootServletInitializer
@SpringBootApplication
public class ZoneApplication {

//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(ZoneApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(ZoneApplication.class, args);
	}

}
