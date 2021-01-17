package com.osanda.classservice.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class StudentDto implements Serializable {

	private static final long serialVersionUID = -1535546938548983782L;

	private String id;

	private String name;

	private Integer age;

	private String gender;

	private String classId;

}
