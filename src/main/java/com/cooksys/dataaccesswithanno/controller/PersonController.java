package com.cooksys.dataaccesswithanno.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dataaccesswithanno.dto.PersonWithIdDto;
import com.cooksys.dataaccesswithanno.dto.PersonWithInterestsDto;
import com.cooksys.dataaccesswithanno.dto.PersonWithLocationDto;
import com.cooksys.dataaccesswithanno.dto.PersonWithoutIdDto;
import com.cooksys.dataaccesswithanno.mapper.PersonMapper;
import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.pojo.Location;
import com.cooksys.dataaccesswithanno.pojo.Person;
import com.cooksys.dataaccesswithanno.service.PersonService;

@RestController
@RequestMapping("people")
public class PersonController {
	
	private PersonService personService;
	private PersonMapper pMapper;

	public PersonController(PersonService personService, PersonMapper pMapper) {
		this.personService = personService;
		this.pMapper = pMapper;
	}

	//get @GetMapping("person")
	@GetMapping("person")
	public List<PersonWithIdDto> get(@RequestParam(required = false, value = "firstname") String firstName, @RequestParam(required = false, value = "lastname") String lastName, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		if (firstName != null || lastName != null) {
			return mapPersonList(personService.getByName(firstName, lastName));
		}
		return mapPersonList(personService.getAll());
	}
	
	private List<PersonWithIdDto> mapPersonList(List<Person> people) {
		return people.stream().map(person -> pMapper.tIdDto(person)).collect(Collectors.toList());
	}
	
	//getPerson @GetMapping("person/{id}")
	@GetMapping("person/{id}")
	public PersonWithoutIdDto getPerson(@PathVariable Long id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		return pMapper.toPersonWithoutIdDto(personService.getById(id));
	}
	
	//createPerson @PostMapping("person")
	@PostMapping("person")
	public Person createPerson(@RequestBody PersonWithoutIdDto person, @RequestParam(required = false, value="locationId") Long locationId,  HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return personService.createPerson(pMapper.toPerson(person));
	}
	
	//updatePerson @PostMapping("person/{id}")
	@PostMapping("person/{id}")
	public Person updatePerson(@RequestBody PersonWithoutIdDto person, @RequestParam(required = false, value="locationId") Long locationId, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return personService.updatePerson(pMapper.toPerson(person));
	}
	//getPersonInterests @GetMapping("person/{id}/interests")
	@GetMapping("person/{id}/interests")
	public PersonWithInterestsDto getPersonInterests(@PathVariable Long id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		return pMapper.personWithInterests(personService.getById(id));
	}
	//addPersonInterest @PostMapping("person/{personId}/interest/{interestId}")
	@PostMapping("person/{personId}/interest/{interestId}")
	public PersonWithInterestsDto addPersonInterest(@PathVariable Long personId, @PathVariable Long interestId, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return pMapper.personWithInterests(personService.addInterest(personId, interestId));
	}
	//getPersonLocation @GetMapping("person/{id}/location")
	@GetMapping("person/{id}/location")
	public PersonWithLocationDto getPersonLocation(@PathVariable Long id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		return pMapper.personWithLocationDto(personService.getById(id));
	}
	//addPersonLocation @PostMapping("person/{personId}/location/{locationId}")
	@PostMapping("person/{personId}/location/{locationId}")
	public PersonWithLocationDto addPersonLocation(@PathVariable Long personId, @PathVariable Long locationId, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return pMapper.personWithLocationDto(personService.addLocation(personId, locationId));
	}
}
