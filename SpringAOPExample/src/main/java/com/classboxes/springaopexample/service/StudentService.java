package com.classboxes.springaopexample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.classboxes.springaopexample.exception.ResourceNotFoundException;
import com.classboxes.springaopexample.repository.StudentRepository;
import com.classboxes.springaopexample.student.Student;

public class StudentService {
	
	@Autowired
	StudentRepository studRepository;

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studRepository.findAll();
	}

	public Optional<Student> getStudentById(Long studentId) {
		// TODO Auto-generated method stub
	
		return studRepository.findById(studentId);
	}

	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studRepository.save(student);
	}

	public Student updateStudent(Long studentId, Student student) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Student updateStudent = studRepository.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("Student does not exist"));
		
		updateStudent.setEmailId(student.getEmailId());
		updateStudent.setFirstName(student.getFirstName());
		updateStudent.setLastName(student.getLastName());
		final Student updatedStudent = studRepository.save(updateStudent);
		return updatedStudent;
	}

	public Map<String, Boolean> deleteStudent(Long studentId) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		
		Student deleteStudent = studRepository.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("Student does not exist"));
		studRepository.delete(deleteStudent);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}

}
