package com.cooksys.dataaccesswithanno.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dataaccesswithanno.dto.LocationWithOutIdDto;
import com.cooksys.dataaccesswithanno.mapper.LocationMapper;
import com.cooksys.dataaccesswithanno.pojo.Location;
import com.cooksys.dataaccesswithanno.service.LocationService;

@RestController
@RequestMapping("peoplelocation")
public class LocationController {

	private LocationService locationService;
	private LocationMapper lMapper;

	public LocationController(LocationService locationService, LocationMapper lMapper) {
		this.locationService = locationService;
		this.lMapper = lMapper;
	}
	
	//Gets all locations or by requested city, state, or country
	@GetMapping("location")
	public List<Location> getAll(@RequestParam(required = false, value = "city") String city,
			@RequestParam(required = false, value = "state") String state,
			@RequestParam(required = false, value = "country") String country, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		if (city != null || state != null || country != null) {
			return locationService.getByValues(city, state, country);
		}
		return locationService.getAll();
	}
	
	//Creates a location
	@PostMapping("location")
	public Location createLoc(@RequestBody LocationWithOutIdDto location, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return locationService.createLocation(lMapper.toLocation(location));
	}
	
	//Gets a location by its ID
	@GetMapping("location/{id}")
	public LocationWithOutIdDto getLocation(@PathVariable Integer id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		return lMapper.tLocationWithOutIdDto(locationService.getById(id));
	}
	
	//Updates a location by id
	@PostMapping("location/{id}")
	public LocationWithOutIdDto update(@PathVariable Integer id, 
			@RequestParam(required = false, value = "city") String city,
			@RequestParam(required = false, value = "state") String state,
			@RequestParam(required = false, value = "country") String country, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		return lMapper.tLocationWithOutIdDto(locationService.updateLoc(id, city, state, country));
	}
}
