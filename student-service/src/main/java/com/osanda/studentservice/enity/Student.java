package com.osanda.studentservice.enity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.osanda.studentservice.dto.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student_details")
public class Student implements Serializable {

	private static final long serialVersionUID = -7896190421525169468L;

	@Id
	private String id;

	private String name;

	private Integer age;

	private String gender;

	private String classId;

	public Student (StudentDto dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.age = dto.getAge();
		this.gender = dto.getGender();
		
	}
}
