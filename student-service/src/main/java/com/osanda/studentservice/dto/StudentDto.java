package com.osanda.studentservice.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {

	private String id;

	@NotNull(message = "Student name cannot be NULL")
	private String name;

	private Integer age;

	private String gender;

	private String classId;

}
