package com.osanda.classservice.entity;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.osanda.classservice.dto.SchoolClassDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "class")
public class SchoolClass implements Serializable {

	private static final long serialVersionUID = -8528034757986445304L;

	@Id
	private String id;

	private String name;

	private String type;

	private String description;

	private Set<String> studentIdList;

	public SchoolClass(SchoolClassDto classDto) {
		this.id = classDto.getId();
		this.name = classDto.getName();
		this.type = classDto.getType();
		this.description = classDto.getDescription();

	}

}
