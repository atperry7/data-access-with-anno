package com.cooksys.dataaccesswithanno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.repository.InterestRepository;
import com.cooksys.dataaccesswithanno.repository.JpaInterestRepository;

@Service
public class InterestService {

	//private InterestRepository iRepository;
	private JpaInterestRepository iRepository;
	
	public InterestService(JpaInterestRepository iRepository) {
		this.iRepository = iRepository;
	}
	
	public Interest createInterest(Interest interest) {
		return iRepository.save(interest);
	}

	public Interest getById(Integer id) {
		return iRepository.getOne(id);
	}

	public List<Interest> getAll() {
		return iRepository.findAll();
	}

	public List<Interest> getByTitle(String interest) {
		return iRepository.findByTitle(interest);
	}

	public Interest update(String title, Integer id) {
		Interest interest = getById(id);
		if (title != null) {
			interest.setTitle(title);
		}
		return iRepository.save(interest);
	}
	
	

}
