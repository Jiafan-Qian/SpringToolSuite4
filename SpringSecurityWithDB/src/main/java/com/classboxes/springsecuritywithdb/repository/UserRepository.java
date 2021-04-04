package com.classboxes.springsecuritywithdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classboxes.springsecuritywithdb.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
