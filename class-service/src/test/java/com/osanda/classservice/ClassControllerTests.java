package com.osanda.classservice;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osanda.classservice.controller.ClassController;
import com.osanda.classservice.dto.SchoolClassDto;
import com.osanda.classservice.entity.SchoolClass;
import com.osanda.classservice.repository.ClassRepository;
import com.osanda.classservice.service.ClassService;

@WebMvcTest(ClassController.class)
class ClassControllerTests {

	@Autowired private MockMvc mvc;

	@MockBean private ClassService classService;
	
	@Mock private ClassRepository classRepository;

	SchoolClass schoolClass;
	SchoolClassDto schoolClassDto;
	List<SchoolClass> allSchoolClass;

	@BeforeEach
	public void initMethod() {

		schoolClass = new SchoolClass("hhsg12d11212", "Class-A", "GRADE-1", "This is grade one class romm");
		allSchoolClass = Arrays.asList(schoolClass);

		this.schoolClassDto = new SchoolClassDto(schoolClass);

		Mockito.when(classService.getAllClasses()).thenReturn(allSchoolClass);
		
		Mockito.when(classService.getClassById("1")).thenReturn(schoolClass);
	}

	@Test
	void getAllClasses() throws Exception {

		mvc.perform(get("/class/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is(schoolClass.getName())));
	}

	@Test
	void saveClass() throws Exception {
		
		Mockito.when(classService.saveStudentClass(this.schoolClassDto)).thenReturn(schoolClass);

		mvc.perform(post("/class/").content(asJsonString(this.schoolClassDto)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}

	public static String asJsonString(final SchoolClassDto obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void getClassById() throws Exception {

		mvc.perform(get("/class/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

	}

	@Test
	void updateAllClassDetails() throws Exception {

		mvc.perform(put("/class/1").content(asJsonString(this.schoolClassDto)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	@Test
	void updateSelectedFeildsClass() throws Exception {

		mvc.perform(
				patch("/class/1").content(asJsonString(this.schoolClassDto)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.description").exists());
	}
	
	@Test
	void deleteClass() throws Exception {

		mvc.perform(
				delete("/class/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
