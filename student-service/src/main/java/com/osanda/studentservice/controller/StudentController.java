package com.osanda.studentservice.controller;

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

import com.osanda.studentservice.dto.StudentDto;
import com.osanda.studentservice.services.StudentService;

@RestController
@RequestMapping(value = "${spring.data.rest.base-path}/")
public class StudentController {

	@Inject
	private StudentService studentService;

	@PostMapping("")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentDto studentDto) {
		return ResponseEntity.ok(studentService.saveStudent(studentDto));
	}

	@GetMapping("")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getStidentById(@PathVariable String id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		 studentService.getStudentById(id);
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateAllStudentDetails(@Valid @RequestBody StudentDto studentDto) {
		return ResponseEntity.ok(studentService.saveStudent(studentDto));
	}
	
	@PatchMapping("")
	public ResponseEntity<?> updateAnyStudentDetails(@Valid @RequestBody StudentDto studentDto) {
		return ResponseEntity.ok(studentService.saveStudent(studentDto));
	}
}
