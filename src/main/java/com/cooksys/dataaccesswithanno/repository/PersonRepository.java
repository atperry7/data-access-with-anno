package com.cooksys.dataaccesswithanno.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.pojo.Person;

@Repository
public class PersonRepository {
	
	EntityManager eManager;
	
	public PersonRepository(EntityManager eManager) {
		this.eManager = eManager;
	}

	public List<Person> getByName(String firstName, String lastName) {
		CriteriaBuilder builder = eManager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
		Root<Person> root = criteriaQuery.from(Person.class);
		
		return eManager.createQuery(
				criteriaQuery.where(
						builder.or(
								builder.equal(root.get("firstName"), firstName),
								builder.equal(root.get("lastName"), lastName)
								)
						)
				).getResultList();
	}

	public List<Person> getAll() {
		return eManager.createQuery("from Person", Person.class).getResultList();
	}

	public Person getById(Long id) {
		return eManager.find(Person.class, id);
	}

	@Transactional
	public Person create(Person person) {
		eManager.persist(person);
		return person;
	}

	public Person getLocation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Person updatePerson(Person person) {
		eManager.merge(person);
		return person;
	}
	
}
