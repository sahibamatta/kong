package com.example.kong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class KongNewApplication {

	public static void main(String[] args) {
		System.out.println("kong main");
		SpringApplication.run(KongNewApplication.class, args);
	}

}
