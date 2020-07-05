package com.phoneBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PhonebookAppMiniProj1Application {

	
	
	public static void main(String[] args) {
		SpringApplication.run(PhonebookAppMiniProj1Application.class, args);
	}
}
