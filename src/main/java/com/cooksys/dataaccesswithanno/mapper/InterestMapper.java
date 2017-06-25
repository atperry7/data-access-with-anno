package com.cooksys.dataaccesswithanno.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dataaccesswithanno.dto.InterestWithOutId;
import com.cooksys.dataaccesswithanno.pojo.Interest;

@Mapper(componentModel = "spring")
public interface InterestMapper {

	InterestWithOutId withOutId(Interest i);
	Interest toInterest(InterestWithOutId i);
	
}
