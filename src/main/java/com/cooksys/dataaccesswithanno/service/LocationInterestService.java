package com.cooksys.dataaccesswithanno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Person;
import com.cooksys.dataaccesswithanno.repository.LocationInterestRepository;

@Service
public class LocationInterestService {
	
	private LocationInterestRepository liRepo;

	public LocationInterestService(LocationInterestRepository liRepo) {
		this.liRepo = liRepo;
	}

	public List<Person> pplInterestByLocation(Long locationId, Long interestId) {
		return liRepo.pplInterestLocation(locationId, interestId);
	}

}
