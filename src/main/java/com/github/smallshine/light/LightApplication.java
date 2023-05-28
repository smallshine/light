package com.github.smallshine.light;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LightApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightApplication.class, args);
	}

}
