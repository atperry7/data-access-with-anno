package com.cooksys.dataaccesswithanno.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository {

	EntityManager eManager;
	
	public LocationRepository(EntityManager eManager) {
		this.eManager = eManager;
	}
	
}
