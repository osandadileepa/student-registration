package com.osanda.classservice.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentAssignPayload {

	@NotNull(message = "Class Id cannot be NULL")
	@NotBlank(message = "Class Id cannot be blank")
	private String classId;
	
	@NotNull(message = "Student Id cannot be NULL")
	@NotBlank(message = "Student Id cannot be blank")
	private String studentId;

}
