package com.cooksys.dataaccesswithanno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Location;
import com.cooksys.dataaccesswithanno.repository.LocationRepository;

@Service
public class LocationService {

	private LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getByValues(String city, String state, String country) {
		return locationRepository.getByValue(city, state, country);
	}

	public List<Location> getAll() {
		return locationRepository.getAll();
	}

	public Location createLocation(Location location) {
		return locationRepository.create(location);
	}

	public Location getById(Long id) {
		return locationRepository.getById(id);
	}

	public Location updateLoc(Long id, String city, String state, String country) {
		Location location = getById(id);
		
		if (city != null) {
			location.setCity(city);
		}
		
		if (state != null) {
			location.setState(state);
		}
		
		if (country != null) {
			location.setCountry(country);
		}
		
		
		
		return locationRepository.update(location);
	}

}
