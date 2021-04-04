package com.classboxes.junitandmockitoexample.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.classboxes.junitandmockitoexample.GreetingBusiness;
import com.classboxes.junitandmockitoexample.GreetingService;

public class GreetingBusinessMock {

	@Test
	public void mockTestGreetingBusiness()
	{
		//GreetingService doGreatingService = new GreetingServiceStub();
		
		GreetingService doGreetingService = mock(GreetingService.class);
		
		List<String> greetings = Arrays.asList("Happy Birthday","Happy New Year","Happy Christmas");
		
		when(doGreetingService.getGreetings("Happy New Year")).thenReturn(greetings);
		
		GreetingBusiness gBusiness = new GreetingBusiness(doGreetingService);
		
		List<String> allGreetings = gBusiness.getGreetingsforNewYear("Happy New Year");
		
		System.out.println(allGreetings);
		assertEquals(1, allGreetings.size());
		
		System.out.println("Stub is working properly...");
		
		
	}
}
