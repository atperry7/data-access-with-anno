package com.cooksys.dataaccesswithanno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.dataaccesswithanno.pojo.Interest;

public interface JpaInterestRepository extends JpaRepository<Interest, Integer>{
	
	List<Interest> findByTitle(String title);

}
