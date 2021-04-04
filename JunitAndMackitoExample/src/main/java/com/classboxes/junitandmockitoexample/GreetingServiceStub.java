package com.classboxes.junitandmockitoexample;

import java.util.Arrays;
import java.util.List;

public class GreetingServiceStub implements GreetingService{

	public List<String> getGreetings(String message) {
		// TODO Auto-generated method stub
		return Arrays.asList("Happy Birthday","Happy New Year","Happy Thanks");
	}

}
