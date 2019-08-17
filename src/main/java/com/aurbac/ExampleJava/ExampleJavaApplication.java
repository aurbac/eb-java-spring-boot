package com.aurbac.ExampleJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class ExampleJavaApplication extends SpringBootServletInitializer {

	@RequestMapping("/")
	String home() {
		return "Hello AWS Elastic Beanstalk";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleJavaApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ExampleJavaApplication.class);
	}

}
