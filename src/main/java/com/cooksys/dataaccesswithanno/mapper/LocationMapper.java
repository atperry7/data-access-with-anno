package com.cooksys.dataaccesswithanno.mapper;

import org.mapstruct.Mapper;

import com.cooksys.dataaccesswithanno.dto.LocationWithOutIdDto;
import com.cooksys.dataaccesswithanno.pojo.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {
	
	LocationWithOutIdDto tLocationWithOutIdDto(Location l);
	Location toLocation(LocationWithOutIdDto l);
	
}
