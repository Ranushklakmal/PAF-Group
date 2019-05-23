package com.ranusau.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CategoryApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(CategoryApplicationTest.class, args);
	}
}
