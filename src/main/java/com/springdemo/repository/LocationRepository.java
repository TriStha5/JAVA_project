package com.springdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	Optional<Location> findByName(String name);
	
	List<Location> findByType(String type);

	Object getByAddress(String address);

	List<Location> findByAddress(String address);

}
