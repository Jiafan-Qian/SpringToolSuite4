package com.classboxes.springaopexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3892816811325475630L;
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
	

}
