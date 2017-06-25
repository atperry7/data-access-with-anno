package com.cooksys.dataaccesswithanno.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.dataaccesswithanno.pojo.Location;

@Repository
public class LocationRepository {

	EntityManager eManager;
	
	public LocationRepository(EntityManager eManager) {
		this.eManager = eManager;
	}

	public List<Location> getByValue(String city, String state, String country) {
		CriteriaBuilder builder = eManager.getCriteriaBuilder();
		CriteriaQuery<Location> criteriaQuery = builder.createQuery(Location.class);
		Root<Location> root = criteriaQuery.from(Location.class);
		
		return eManager.createQuery(
				criteriaQuery.where(
						builder.or(
								builder.equal(root.get("city"), city),
								builder.equal(root.get("state"), state),
								builder.equal(root.get("country"), country)
								)
						)
				).getResultList();
	}

	public List<Location> getAll() {
		return eManager.createQuery("from Location", Location.class).getResultList();
	}

	@Transactional
	public Location create(Location location) {
		eManager.persist(location);
		return location;
	}

	public Location getById(Long id) {
		return eManager.find(Location.class, id);
	}

	@Transactional
	public Location update(Location location) {
		eManager.merge(location);
		return getById(location.getId());
	}
	
}
