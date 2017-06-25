package com.cooksys.dataaccesswithanno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.repository.InterestRepository;

@Service
public class InterestService {

	private InterestRepository iRepository;

	public InterestService(InterestRepository iRepository) {
		this.iRepository = iRepository;
	}
	
	public Interest createInterest(Interest interest) {
		return iRepository.create(interest);
	}

	public Interest getById(Long id) {
		return iRepository.getById(id);
	}

	public List<Interest> getAll() {
		return iRepository.getAll();
	}

	public List<Interest> getByTitle(String interest) {
		return iRepository.searchByTitle(interest);
	}

	public Interest update(String title, Long id) {
		Interest interest = getById(id);
		if (title != null) {
			interest.setTitle(title);
		}
		return iRepository.update(interest);
	}
	
	

}
