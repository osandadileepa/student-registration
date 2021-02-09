package com.osanda.classservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.osanda.classservice.dto.SchoolClassDto;
import com.osanda.classservice.dto.StudentDto;
import com.osanda.classservice.entity.SchoolClass;
import com.osanda.classservice.exception.BadRequestException;
import com.osanda.classservice.exception.InternalServerErrorException;
import com.osanda.classservice.payload.StudentAssignPayload;
import com.osanda.classservice.repository.ClassRepository;
import com.osanda.classservice.util.EndpointUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassService {

	private final ClassRepository classRepository;
	private final RestTemplate restTemplate;

	public SchoolClass saveStudentClass(SchoolClassDto dto) {

		return classRepository.save(new SchoolClass(dto));
	}

	public List<SchoolClass> getAllClasses() {

		return this.classRepository.findAll();
	}

	public SchoolClass getClassById(String id) {

		return this.classRepository.findById(id).orElse(new SchoolClass());
	}
	
	
	public SchoolClass updateDetails(String id, SchoolClassDto dto) {

		SchoolClass update = this.classRepository.findById(id).orElse(new SchoolClass());
		
		update.setName(dto.getName());
		update.setDescription(dto.getDescription());
		update.setType(dto.getType());
		update.setStudentIdList(dto.getStudentList().stream().map(st-> st.getId()).collect(Collectors.toSet()));
		
		return this.classRepository.save(update);
	}

	public void deleteClassById(String id) {
		this.classRepository.deleteById(id);
		log.info("Student deleted with id {}", id);
	}

	/***
	 * get the class with all the student detaills
	 * 
	 * @author Osanda Wedamulla
	 * @param classId
	 * @see StudentDto SchoolClassDto
	 * @return SchoolClassDto
	 */
	public SchoolClassDto getClassesWithStudents(String classId) {

		SchoolClassDto classDto = new SchoolClassDto();

		Set<StudentDto> studentSet = new HashSet<>();

		SchoolClass classGet = this.getClassById(classId);

		if (classGet != null) {

			classGet.getStudentIdList().forEach(studentId -> {

				String url = EndpointUtils.STUDENT_GET_URL + "student/"+ studentId + "/";

				ResponseEntity<StudentDto> response;
				log.info("Call URL : " + url);
				try {
					response = this.restTemplate.getForEntity(url, null, StudentDto.class);
				} catch (Exception e) {
					log.error("Error calling student service ", e);
					throw new InternalServerErrorException(503, "Student Service not vailable",
							"Service takes tood much time to response.");
				}

				if (response != null && response.getStatusCode() == HttpStatus.OK) {
					studentSet.add(response.getBody());
				}

			});

			classDto.setStudentList(studentSet);

		} else {
			throw new InternalServerErrorException(500, "Plase specify correct class id !!",
					"Requested class not found.");
		}

		return classDto;

	}

	public Boolean assignStudentToClass(@Valid StudentAssignPayload request) {

		boolean status = false;

		SchoolClass studentClass = this.getClassById(request.getClassId());

		if (studentClass != null) {

			Set<String> studentList = studentClass.getStudentIdList();

			if (studentList == null) {
				studentList = new HashSet<>();
			}
			studentList.add(request.getStudentId());

			studentClass.setStudentIdList(studentList);

			try {
				this.classRepository.save(studentClass);
				log.info("Student assign to class " + studentClass.getName());
				status = true;
			} catch (Exception e) {
				log.error("Error saving student assignmnet", e);
			}
		} else {
			throw new BadRequestException(400, "Plase specify correct class id !!",
					"Requested Student class not found.");
		}

		return status;
	}// getClassesWithStudents()
}