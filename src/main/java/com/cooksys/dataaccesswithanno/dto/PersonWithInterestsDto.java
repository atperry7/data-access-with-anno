package com.cooksys.dataaccesswithanno.dto;

import java.util.HashSet;
import java.util.Set;

import com.cooksys.dataaccesswithanno.pojo.Interest;

public class PersonWithInterestsDto {
	private String firstName;
	private String lastName;
	private Set<Interest> interest = new HashSet<>();

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

	public Set<Interest> getInterest() {
		return interest;
	}

	public void setInterest(Set<Interest> interest) {
		this.interest = interest;
	}

}
