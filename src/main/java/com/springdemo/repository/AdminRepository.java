package com.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByEmailAndPassword(String email, String password);
	
	boolean existsByEmailAndPassword(String email, String password);

	Admin findAllByEmail(String email);

}
