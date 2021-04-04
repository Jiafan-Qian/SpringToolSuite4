package com.classboxes.lombakexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Employee {
	
	@NonNull 
	@Id
	@GeneratedValue
	private Long id;
	private String empName;
	private float empSalary;
	

}
