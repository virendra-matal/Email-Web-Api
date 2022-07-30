package com.intellij.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailWebApiBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailWebApiBootApplication.class, args);
	}

}
