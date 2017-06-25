package com.cooksys.dataaccesswithanno.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dataaccesswithanno.dto.PersonWithIdDto;
import com.cooksys.dataaccesswithanno.dto.PersonWithInterestsDto;
import com.cooksys.dataaccesswithanno.dto.PersonWithLocationDto;
import com.cooksys.dataaccesswithanno.dto.PersonWithoutIdDto;
import com.cooksys.dataaccesswithanno.pojo.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonWithoutIdDto toPersonWithoutIdDto(Person p);
	Person toPerson(PersonWithoutIdDto p);
	PersonWithIdDto tIdDto(Person p);
	Person toPerson(PersonWithIdDto p);
	PersonWithInterestsDto personWithInterests(Person p);
	PersonWithLocationDto personWithLocationDto(Person p);
}
