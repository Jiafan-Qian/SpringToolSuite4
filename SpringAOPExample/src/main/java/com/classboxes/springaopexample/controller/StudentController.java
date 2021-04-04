package com.classboxes.springaopexample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classboxes.springaopexample.exception.ResourceNotFoundException;
import com.classboxes.springaopexample.service.StudentService;
import com.classboxes.springaopexample.student.Student;


@RestController
@RequestMapping("api/vi")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId)
	throws ResourceNotFoundException
	{
		Student  student = studentService.getStudentById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("student not found with this: " + studentId));
		
		return ResponseEntity.ok().body(student);
	
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student)
	{
		return studentService.createStudent(student);
	}
	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable(value="id") Long studentId, @RequestBody Student student)
			throws ResourceNotFoundException
			{
				Student updatedStudent = studentService.updateStudent(studentId, student);
						//.orElseThrow(()->new ResourceNotFoundException("student not found with this: " + studentId));
				if (student.equals(null))
					throw new ResourceNotFoundException("Student does not exist");
				else
					return ResponseEntity.ok().body(student);
			
			}
	
	
	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value="id") Long studentId)
			throws ResourceNotFoundException
			{
				return studentService.deleteStudent(studentId);
		
			}
	
	

}
