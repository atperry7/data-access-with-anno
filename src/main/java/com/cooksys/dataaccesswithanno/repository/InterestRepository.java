package com.cooksys.dataaccesswithanno.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.dataaccesswithanno.pojo.Interest;

@Repository
public class InterestRepository {

	EntityManager eManager;
	
	public InterestRepository(EntityManager eManager) {
		this.eManager = eManager;
	}

	@Transactional
	public Interest create(Interest interest) {
		eManager.persist(interest);
		return interest;
	}

	public Interest getById(Long id) {
		return eManager.find(Interest.class, id);
	}

	public List<Interest> getAll() {
		return eManager.createQuery("from Interest", Interest.class).getResultList();
	}

	public List<Interest> searchByTitle(String interest) {
		CriteriaBuilder builder = eManager.getCriteriaBuilder();
		CriteriaQuery<Interest> criteriaQuery = builder.createQuery(Interest.class);
		Root<Interest> root = criteriaQuery.from(Interest.class);
		
		return eManager.createQuery(
				criteriaQuery.where(
						builder.or(
								builder.equal(root.get("title"), interest)
								)
						)
				).getResultList();
	}
	
}
