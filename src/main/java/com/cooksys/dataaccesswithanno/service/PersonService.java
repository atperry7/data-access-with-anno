package com.cooksys.dataaccesswithanno.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Person;
import com.cooksys.dataaccesswithanno.repository.PersonRepository;

@Service
public class PersonService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	private PersonRepository pRepository;
	private LocationService lService;
	private InterestService iService;
	
	public PersonService(PersonRepository pRepository, LocationService lService, InterestService iService) {
		this.pRepository = pRepository;
		this.lService = lService;
		this.iService = iService;
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
		Person person = getById(personId);
		
		if (interestId != null) {
			person.getInterests().add(iService.getById(interestId));			
		}
		
		return pRepository.updatePerson(person);
	}

	public Person addLocation(Long personId, Long locationId) {
		Person person = getById(personId);
		if (locationId != null) {
			person.setLocation(lService.getById(locationId));			
		}
		return pRepository.updatePerson(person);
	}

	public Person updatePerson(Long id, String firstName, String lastName, Long locationId) {
		Person person = pRepository.getById(id);
		
		if (firstName != null) {
			person.setFirstName(firstName);
		}
		
		if (lastName != null) {
			person.setLastName(lastName);
		}
		
		if (locationId != null) {
			person.setLocation(lService.getById(locationId));
		}
		
		return pRepository.updatePerson(person);
	}

}
