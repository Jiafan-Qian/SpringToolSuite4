package com.classboxes.greeting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.greeting.model.Greeting;

@RestController
public class GreetingController 
{
	String greetingtemplate = "Welcome to JAVA FULL STACK TRAINING";
	@RequestMapping(path="/greeting/{name}", produces=MediaType.TEXT_PLAIN_VALUE)
	public Greeting greeting(@PathVariable("name")String name)
	{
		return new Greeting(12345,greetingtemplate);
	}

	@RequestMapping(path="/listnames", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> listNames()
	{
		List<String> names = new ArrayList<String>();
		names.add("tina");
		names.add("tony");
		names.add("tintu");
		return names;
	}
}
