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
		return "<img src=\"https://github.com/aurbac/eb-java-spring-boot/raw/master/images/beanstalk.png\"><h1>Welcome to AWS Elastic Beanstalk</h1>";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleJavaApplication.class, args);
	}
	

}
