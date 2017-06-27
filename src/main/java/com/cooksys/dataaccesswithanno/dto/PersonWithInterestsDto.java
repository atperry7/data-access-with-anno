package com.cooksys.dataaccesswithanno.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cooksys.dataaccesswithanno.pojo.Interest;

public class PersonWithInterestsDto {
	private String firstName;
	private String lastName;
	private Set<InterestWithOutId> interests = new HashSet<>();

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

	public Set<InterestWithOutId> getInterests() {
		return interests;
	}

	public void setInterests(Set<InterestWithOutId> interests) {
		this.interests = interests;
	}

}
