package com.example.springbootjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		System.out.println(System.getenv("SPRING_DATASOURCE_URL"));

		System.out.println(System.getenv("PGHOST"));
		SpringApplication.run(DemoApplication.class, args);
	}
}
 