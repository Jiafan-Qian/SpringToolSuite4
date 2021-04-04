package com.classboxes.junitandmockitoexample;

import java.util.ArrayList;
import java.util.List;

public class GreetingBusiness {
	
	public GreetingService greetingService;

	public GreetingBusiness(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}
	
	public List<String> getGreetingsforNewYear(String message)
	{
		List<String> retrievedGreetings = new ArrayList<String>();
		List<String> greetings = greetingService.getGreetings(message);
		
		for(String greeting:greetings)
		{
			if (greeting.contains("New Year"))
			{
				retrievedGreetings.add(greeting);
			}
		}
		
		return retrievedGreetings;
	}

}
