package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

@RestController
public class Sample 
{

	@RequestMapping("/hello")
	public String firstPage()
	{
		return "hello welcome to Spring Boot";
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to 2021";
	}
}
