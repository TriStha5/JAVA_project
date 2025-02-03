package com.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	Message findAllByReply(String reply);

}
