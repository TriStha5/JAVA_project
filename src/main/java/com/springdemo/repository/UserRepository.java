package com.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	User findByEmailAndPassword(String email, String password);
	
	boolean existsByEmailAndPassword(String email, String password);
	
	
	
}
