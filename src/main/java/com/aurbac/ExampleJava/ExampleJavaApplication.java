package com.aurbac.ExampleJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class ExampleJavaApplication {

	@RequestMapping("/")
	String home() {
		return "Welcome to AWS Elastic Beanstalk";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleJavaApplication.class, args);
	}
	

}
