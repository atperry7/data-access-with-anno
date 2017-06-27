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

import com.cooksys.dataaccesswithanno.dto.InterestWithOutId;
import com.cooksys.dataaccesswithanno.mapper.InterestMapper;
import com.cooksys.dataaccesswithanno.pojo.Interest;
import com.cooksys.dataaccesswithanno.service.InterestService;

@RestController
@RequestMapping("peopleinterest")
public class InterestController {

	private InterestService iService;
	private InterestMapper iMapper;

	public InterestController(InterestService iService, InterestMapper iMapper) {
		this.iService = iService;
		this.iMapper = iMapper;
		
	}
	
	//Gets a list of all interests or by requested title of interest
	@GetMapping("interest")
	public List<Interest> getAll(@RequestParam(required = false, value="interest") String interest, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		
		if (interest != null) {
			return iService.getByTitle(interest);
		}
		
		return iService.getAll();
	}
	
	//Gets an interest by its id
	@GetMapping("interest/{id}")
	public InterestWithOutId getInterest(@PathVariable Integer id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_ACCEPTED);
		return iMapper.withOutId(iService.getById(id));
	}
	
	//Creates an interests
	@PostMapping("interest")
	public Interest create(@RequestBody InterestWithOutId interest, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return iService.createInterest(iMapper.toInterest(interest));
	}
	
	//Updates an interest by ID
	@PostMapping("interest/{id}")
	public InterestWithOutId updateInterest(@RequestParam(required = true, value = "title") String title, @PathVariable Integer id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FOUND);
		return iMapper.withOutId(iService.update(title, id));
	}
}
