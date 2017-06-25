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
	
	//get @GetMapping("interest")
	@GetMapping("interest")
	public List<Interest> getAll(@RequestParam(required = false, value="interest") String interest, HttpServletResponse response) {
		if (interest != null) {
			return iService.getByTitle(interest);
		}
		
		return iService.getAll();
	}
	
	//getInterest @GetMapping("interest/{id}")
	@GetMapping("interest/{id}")
	public InterestWithOutId getInterest(@PathVariable Long id, HttpServletResponse response) {
		return iMapper.withOutId(iService.getById(id));
	}
	
	//createInterest @PostMapping("interest")
	@PostMapping("interest")
	public Interest create(@RequestBody InterestWithOutId interest, HttpServletResponse response) {
		return iService.createInterest(iMapper.toInterest(interest));
	}
	
	//updateInterest @PostMapping("interest/{id}")
}
