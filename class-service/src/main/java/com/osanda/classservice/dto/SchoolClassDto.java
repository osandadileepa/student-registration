package com.osanda.classservice.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SchoolClassDto {

	private String id;

	@NotNull(message = "School name cannot be NULL")
	private String name;

	private String type;

	@Size(min = 10, max = 200)
	private String description;

}
