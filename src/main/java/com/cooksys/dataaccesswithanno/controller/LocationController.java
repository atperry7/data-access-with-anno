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
	
	//get @GetMapping("location")
	@GetMapping("location")
	public List<Location> getAll(@RequestParam(required = false, value = "city") String city,
			@RequestParam(required = false, value = "state") String state,
			@RequestParam(required = false, value = "country") String country, HttpServletResponse response) {
		if (city != null || state != null || country != null) {
			return locationService.getByValues(city, state, country);
		}
		return locationService.getAll();
	}
	
	//createLocation @PostMapping("location")
	@PostMapping("location")
	public Location createLoc(@RequestBody LocationWithOutIdDto location, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return locationService.createLocation(lMapper.toLocation(location));
	}
	
	//getLocation @GetMapping("location/{id}")
	@GetMapping("location/{id}")
	public LocationWithOutIdDto getLocation(@PathVariable Long id, HttpServletResponse response) {
		return lMapper.tLocationWithOutIdDto(locationService.getById(id));
	}
	
	//updateLocation @PostMapping("location/{id}")
}
