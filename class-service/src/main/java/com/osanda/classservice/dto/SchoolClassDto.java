package com.osanda.classservice.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.osanda.classservice.entity.SchoolClass;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SchoolClassDto implements Serializable {
	
	
	private static final long serialVersionUID = 2916416144746605888L;

	private String id;

	@NotNull(message = "School name cannot be NULL")
	private String name;

	private String type;

	@Size(min = 10, max = 200)
	private String description;

	private Set<StudentDto> studentList;
	
	public SchoolClassDto(SchoolClass sClass) {
		this.id = sClass.getId();
		this.name = sClass.getName();
		this.type = sClass.getType();
		this.description = sClass.getDescription();	
	}
}
