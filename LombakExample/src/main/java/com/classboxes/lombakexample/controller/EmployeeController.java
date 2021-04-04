package com.classboxes.lombakexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.lombakexample.model.Employee;
import com.classboxes.lombakexample.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empService.findAll();
	}

}
