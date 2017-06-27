package com.cooksys.dataaccesswithanno.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dataaccesswithanno.dto.PersonWithIdDto;
import com.cooksys.dataaccesswithanno.mapper.PersonMapper;
import com.cooksys.dataaccesswithanno.service.LocationInterestService;

@RestController
@RequestMapping("locationinterest")
public class LocationInterestController {

	private LocationInterestService liService;
	private PersonMapper pMapper;

	public LocationInterestController(LocationInterestService liService, PersonMapper pMapper) {
		this.liService = liService;
		this.pMapper = pMapper;
	}
	
	//Gets a list of people by location with a specific interest
	@GetMapping("location/{locationId}/interest/{interestId}")
	public List<PersonWithIdDto> interestByLocation(@PathVariable Integer locationId, @PathVariable Integer interestId, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return liService.pplInterestByLocation(locationId, interestId).stream().map(person -> pMapper.tIdDto(person)).collect(Collectors.toList());
	}
}
