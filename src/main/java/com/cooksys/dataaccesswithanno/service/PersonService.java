package com.cooksys.dataaccesswithanno.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.pojo.Location;
import com.cooksys.dataaccesswithanno.pojo.Person;
import com.cooksys.dataaccesswithanno.repository.PersonRepository;

@Service
public class PersonService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	private PersonRepository pRepository;
	
	public PersonService(PersonRepository pRepository) {
		this.pRepository = pRepository;
	}

	public List<Person> getByName(String firstName, String lastName) {
		return pRepository.getByName(firstName, lastName);
	}

	public List<Person> getAll() {
		return pRepository.getAll();
	}

	public Person getById(Long id) {
		return pRepository.getById(id);
	}

	public Person createPerson(Person person) {
		return pRepository.create(person);
	}

	public Person addInterest(Long personId, Long interestId) {
		return pRepository.updatePerson(null);
	}

	public Person addLocation(Long personId, Long locationId) {
		return pRepository.updatePerson(null);
	}

	public Person updatePerson(Person person) {
		return pRepository.updatePerson(person);
	}

}
