package com.classboxes.lombakexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.classboxes.lombakexample.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	

}
