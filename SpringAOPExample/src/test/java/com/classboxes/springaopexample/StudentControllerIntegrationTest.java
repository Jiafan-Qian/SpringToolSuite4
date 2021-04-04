package com.classboxes.springaopexample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.classboxes.springaopexample.student.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringAopExampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl()
	{
		return "http://localhost:" + port;
	}
	
	@Test
	public void contextLoads()
	{
		
	}
	
	@Test
	public void testGetAllStudents()
	{
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl()+"/students", HttpMethod.GET,entity,String.class);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetStudentById()
	{
		Student student = restTemplate.getForObject(getRootUrl()+"/students/1", Student.class);
		System.out.println(student.getFirstName());
		assertNotNull(student);
	}
	
	@Test
	public void testCreateStudent()
	{
		Student student = new Student();
		student.setEmailId("admin@gmail.com");
		student.setFirstName("admin");
		student.setLastName("admin");
		ResponseEntity<Student> postResponse = restTemplate.postForEntity(getRootUrl()+"/students", student, Student.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testUpdateStudentById()
	{
		int id = 1;
		Student student = restTemplate.getForObject(getRootUrl()+"/students/"+id, Student.class);
		//student.setEmailId("admin@gmail.com");
		student.setFirstName("admin1");
		student.setLastName("admin1");
		restTemplate.put(getRootUrl()+"/students/"+id,student);
		Student updatedStudent = restTemplate.getForObject(getRootUrl()+"/students/1", Student.class);
		assertNotNull(updatedStudent);
	}
	
	//@Test
	//public void testDeleteStudent(){	}
}

