package com.osanda.studentservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {

	private String id;

	@NotNull(message = "Student name cannot be NULL")
	private String name;

	@NotNull(message = "Student age cannot be NULL")
	private Integer age;

	@NotBlank(message = "Student gender cannot be blank")
	private String gender;

	private String classId;

}
