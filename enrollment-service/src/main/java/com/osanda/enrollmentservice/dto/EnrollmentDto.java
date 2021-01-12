package com.osanda.enrollmentservice.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnrollmentDto {
	
	private String id;

	@NotNull(message = "Enrollment name cannot be NULL")
	private String name;
}
