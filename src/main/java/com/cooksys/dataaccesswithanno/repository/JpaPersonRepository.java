package com.cooksys.dataaccesswithanno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.dataaccesswithanno.pojo.Person;

public interface JpaPersonRepository extends JpaRepository<Person, Integer>{
	
	List<Person> findByLocationIdAndInterestsId(Integer locationId, Integer interestId);

}
