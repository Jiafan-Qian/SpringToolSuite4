package com.classboxes.springbootswaggerexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/hello")
	public String sayHello()
	{
		return "Swagger is a tool for testing REST API's";
	}
	

}
