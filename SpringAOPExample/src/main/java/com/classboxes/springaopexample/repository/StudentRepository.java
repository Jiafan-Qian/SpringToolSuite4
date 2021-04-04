package com.classboxes.springaopexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classboxes.springaopexample.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
