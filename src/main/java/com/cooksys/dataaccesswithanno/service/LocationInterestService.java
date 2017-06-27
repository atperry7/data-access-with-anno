package com.cooksys.dataaccesswithanno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Person;
import com.cooksys.dataaccesswithanno.repository.JpaPersonRepository;
import com.cooksys.dataaccesswithanno.repository.LocationInterestRepository;

@Service
public class LocationInterestService {
	
	//private LocationInterestRepository liRepo;
	private JpaPersonRepository personRepo;
	
	public LocationInterestService(JpaPersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	public List<Person> pplInterestByLocation(Integer locationId, Integer interestId) {
		return personRepo.findByLocationIdAndInterestsId(locationId, interestId);
	}

}
