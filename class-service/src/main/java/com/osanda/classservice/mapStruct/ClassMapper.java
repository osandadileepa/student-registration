package com.osanda.classservice.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.osanda.classservice.dto.SchoolClassDto;
import com.osanda.classservice.entity.SchoolClass;

@Mapper
public interface ClassMapper {

	@Mappings({ @Mapping(target = "id", source = "entity.id"), @Mapping(target = "name", source = "entity.name"),
			@Mapping(target = "type", source = "entity.id"), @Mapping(target = "description", source = "entity.name") })
	SchoolClassDto schoolClassToDto(SchoolClass schoolClass);

	@Mappings({ @Mapping(target = "id", source = "classDto.id"), @Mapping(target = "name", source = "classDto.name"),
			@Mapping(target = "type", source = "classDto.type"),
			@Mapping(target = "description", source = "classDto.description") })
	SchoolClass schoolClassDtoToClass(SchoolClassDto classDto);

}
