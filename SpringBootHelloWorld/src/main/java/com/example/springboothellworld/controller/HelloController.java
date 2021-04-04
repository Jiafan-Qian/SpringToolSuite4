package com.example.springboothellworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/welcome")
	public String sayHello()
	{
		return "Welcome to Spring Boot Session";
	}

}
