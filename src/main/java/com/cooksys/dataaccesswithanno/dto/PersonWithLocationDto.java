package com.cooksys.dataaccesswithanno.dto;

import com.cooksys.dataaccesswithanno.pojo.Location;

public class PersonWithLocationDto {
	private String firstName;
	private String lastName;
	private Location location;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
