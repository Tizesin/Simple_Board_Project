package com.example.Simple_Board_Solo_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleBoardSoloProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBoardSoloProjectApplication.class, args);
	}

}
