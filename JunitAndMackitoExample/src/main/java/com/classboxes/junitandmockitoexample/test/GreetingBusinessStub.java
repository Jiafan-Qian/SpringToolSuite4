package com.classboxes.junitandmockitoexample.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.classboxes.junitandmockitoexample.GreetingBusiness;
import com.classboxes.junitandmockitoexample.GreetingService;
import com.classboxes.junitandmockitoexample.GreetingServiceStub;

public class GreetingBusinessStub {

	@Test
	public void test()
	{
		GreetingService doGreatingService = new GreetingServiceStub();
		
		GreetingBusiness gBusiness = new GreetingBusiness(doGreatingService);
		
		List<String> retrivedGreetings = gBusiness.getGreetingsforNewYear("Happy New Year");
		
		assertEquals(1, retrivedGreetings.size());
		
		System.out.println("Stub is working properly...");
		
		
	}
}
