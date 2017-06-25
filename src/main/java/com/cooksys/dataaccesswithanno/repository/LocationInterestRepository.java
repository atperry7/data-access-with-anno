package com.cooksys.dataaccesswithanno.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.pojo.Location;
import com.cooksys.dataaccesswithanno.pojo.Person;

@Repository
public class LocationInterestRepository {
	
	private EntityManager eManager;

	public LocationInterestRepository(EntityManager eManager) {
		this.eManager = eManager;
	}

	public List<Person> pplInterestLocation(Long locationId, Long interestId) {
		CriteriaBuilder builder = eManager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		
		
		return eManager.createQuery(
				criteriaQuery.where(
						builder.and(
								builder.equal(root.get("location"), eManager.find(Location.class, locationId)),
								builder.equal(root.join("interests"), eManager.find(Interest.class, interestId))
								)
						)
				).getResultList();
	}
}
