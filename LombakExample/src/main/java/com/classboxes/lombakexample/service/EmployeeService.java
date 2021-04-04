package com.classboxes.lombakexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classboxes.lombakexample.repository.EmployeeRepository;
import com.classboxes.lombakexample.model.Employee;




@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public List<Employee> findAll()
	{
		Iterable<Employee> empData = empRepository.findAll();
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		empData.forEach(emp -> employees.add(emp));
		
		return employees;
		
	}
}
