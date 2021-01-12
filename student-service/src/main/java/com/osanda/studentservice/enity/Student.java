package com.osanda.studentservice.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data

@ToString
@NoArgsConstructor
@EqualsAndHashCode
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
}
