package com.classboxes.springsecurityexample.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.springsecurityexample.model.AuthenticationBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/vi")
public class BasicAuthController {
	
	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldBean()
	{
		return new AuthenticationBean("You are authenticated");
	}

}
