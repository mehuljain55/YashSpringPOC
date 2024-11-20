package com.SpringSecurityPOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.SpringSecurityPOC")
public class SpringSecurityPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPocApplication.class, args);
	}

}
