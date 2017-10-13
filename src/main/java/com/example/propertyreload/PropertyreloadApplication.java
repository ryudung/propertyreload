package com.example.propertyreload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PropertyreloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyreloadApplication.class, args);
	}
}
