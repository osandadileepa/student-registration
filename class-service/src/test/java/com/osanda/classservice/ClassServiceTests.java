package com.osanda.classservice;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.osanda.classservice.dto.SchoolClassDto;
import com.osanda.classservice.entity.SchoolClass;
import com.osanda.classservice.repository.ClassRepository;
import com.osanda.classservice.service.ClassService;

@ExtendWith(MockitoExtension.class)
class ClassServiceTests {

	@Mock
	private ClassRepository classRepository;

	@InjectMocks
	private ClassService classService;

	private SchoolClassDto classDto;
	private SchoolClass schoolClass;
	
	private String classId = "11shjd5snsd";

	@BeforeEach
	void init() {
		this.classDto = new SchoolClassDto("hhsg12d11212", "Class-A", "GRADE-1", "This is grade one class romm");
		this.schoolClass = new SchoolClass("hhsg12d11212", "Class-A", "GRADE-1", "This is grade one class romm");
		this.schoolClass.setId(classId);

		Mockito.when(this.classRepository.save(new SchoolClass(this.classDto))).thenReturn(this.schoolClass);
		Mockito.when(this.classRepository.findById("11shjd5snsd")).thenReturn(Optional.of(this.schoolClass));
		Mockito.when(this.classRepository.save(this.schoolClass)).thenReturn(this.schoolClass);
	}

	@Test
	void testClassCreation() {

		SchoolClass saveStudentClass = this.classService.saveStudentClass(this.classDto);

		Assertions.assertNotNull(saveStudentClass);

		Assertions.assertEquals(this.classDto.getId(), saveStudentClass.getId());
		Assertions.assertEquals(this.classDto.getName(), saveStudentClass.getName());
		Assertions.assertEquals(this.classDto.getType(), saveStudentClass.getType());
		Assertions.assertEquals(this.classDto.getDescription(), saveStudentClass.getDescription());
	}
	
	@Test
	void getClassById() {

		SchoolClass saveStudentClass = this.classService.getClassById(classId);

		Assertions.assertNotNull(saveStudentClass);

		Assertions.assertEquals(this.classDto.getId(), saveStudentClass.getId());
		Assertions.assertEquals(this.classDto.getDescription(), saveStudentClass.getDescription());
	}
	
	@Test
	void updateClassDetails() {

		SchoolClass saveStudentClass = this.classService.updateDetails(classId, this.classDto);

		Assertions.assertNotNull(saveStudentClass);

		Assertions.assertEquals(this.classDto.getId(), saveStudentClass.getId());
		Assertions.assertEquals(this.classDto.getName(), saveStudentClass.getName());
	}
	
	@Test
	void deleteById() {
		this.classService.deleteClassById(classId);
		Assertions.assertNotNull(classId);
	}

}
