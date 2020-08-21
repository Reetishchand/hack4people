package com.now.hack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class Hack4PeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hack4PeopleApplication.class, args);
	}

}
