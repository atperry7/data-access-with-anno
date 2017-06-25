package com.cooksys.dataaccesswithanno.dto;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.dataaccesswithanno.pojo.Interest;

public class PersonWithInterestsDto {
	private String firstName;
	private String lastName;
	private List<Interest> interests = new ArrayList<>();

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

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

}
