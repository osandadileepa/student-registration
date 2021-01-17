package com.osanda.classservice.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osanda.classservice.dto.SchoolClassDto;
import com.osanda.classservice.payload.StudentAssignPayload;
import com.osanda.classservice.service.ClassService;

@RestController
@RequestMapping(value = "${spring.data.rest.base-path}/")
public class ClassController {

	@Inject
	private ClassService classService;

	@PostMapping("")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody SchoolClassDto studentDto) {
		return ResponseEntity.ok(classService.saveStudentClass(studentDto));
	}

	@GetMapping("")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(classService.getAllClasses());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getStidentById(@PathVariable String id) {
		return ResponseEntity.ok(classService.getClassById(id));
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		classService.getClassById(id);
	}

	@PutMapping("")
	public ResponseEntity<?> updateAllStudentDetails(@Valid @RequestBody SchoolClassDto studentDto) {
		return ResponseEntity.ok(classService.saveStudentClass(studentDto));
	}

	@PatchMapping("")
	public ResponseEntity<?> updateAnyStudentDetails(@Valid @RequestBody SchoolClassDto studentDto) {
		return ResponseEntity.ok(classService.saveStudentClass(studentDto));
	}

	@GetMapping("get-class-students/{id}")
	public ResponseEntity<?> getAllStudentsDetailsWithClass(@PathVariable String id) {
		return ResponseEntity.ok(classService.getClassesWithStudents(id));
	}

	@PostMapping("assign-student")
	public ResponseEntity<?> assignStudentToClass(@Valid @RequestBody StudentAssignPayload request) {
		return ResponseEntity.ok(classService.assignStudentToClass(request));
	}

}
