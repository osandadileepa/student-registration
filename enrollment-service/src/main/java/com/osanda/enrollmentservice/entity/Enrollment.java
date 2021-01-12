package com.osanda.enrollmentservice.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Document(collection = "enrollment")
public class Enrollment implements Serializable {

	private static final long serialVersionUID = -485683597834683400L;

	@Id
	private String id;

	private String name;

	private LocalDate updatedDate;

	private List<String> studentIdList;
}
