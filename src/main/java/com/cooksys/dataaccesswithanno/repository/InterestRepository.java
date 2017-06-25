package com.cooksys.dataaccesswithanno.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class InterestRepository {

	EntityManager eManager;
	
	public InterestRepository(EntityManager eManager) {
		this.eManager = eManager;
	}
	
}
