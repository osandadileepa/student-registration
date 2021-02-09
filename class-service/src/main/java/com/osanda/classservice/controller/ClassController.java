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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "${spring.data.rest.base-path}/")
public class ClassController {

	@Inject
	private ClassService classService;

	@ApiOperation(value = "Create class with details", 
			response = SchoolClassDto.class, 
			httpMethod = "POST", 
			notes = "Returns an instance of created classification Template.")
	@PostMapping("")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody SchoolClassDto studentDto) {
		return ResponseEntity.ok(classService.saveStudentClass(studentDto));
	}
	
	
	@ApiOperation(value = "Return stock quote corresponding to the symbol", notes = "Returns HTTP 404 if the symbol is not found")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All the clas list returned."),
			@ApiResponse(code = 404, message = "No class found for the name") })
	@GetMapping("")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(classService.getAllClasses());
	}

	@ApiOperation(value = "Return stock quote corresponding to the symbol", notes = "Returns HTTP 404 if the symbol is not found")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Class relevant for the id returned."),
			@ApiResponse(code = 404, message = "No class found for the name") })
	@GetMapping("{id}")
	public ResponseEntity<?> getStidentById(@PathVariable String id) {
		return ResponseEntity.ok(classService.getClassById(id));
	}

	@ApiOperation(value = "Delete a deployment", tags = { "Deployment" })
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Indicates the deployment was found and has been deleted. Response-body is intentionally empty."),
			@ApiResponse(code = 404, message = "Indicates the requested deployment was not found.") })
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		classService.getClassById(id);
	}

	@ApiOperation(value = "update DossierFile")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Request feilds of the class is updated."),
			@ApiResponse(code = 404, message = "Indicates the requested deployment was not found.") })
	@PutMapping("{id}")
	public ResponseEntity<?> updateAllStudentDetails(@Valid @RequestBody SchoolClassDto studentDto,
			@PathVariable String id) {
		return ResponseEntity.ok(classService.updateDetails(id, studentDto));
	}

	@ApiOperation(value = "update DossierFile")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Class details update is made."),
			@ApiResponse(code = 404, message = "Indicates the requested deployment was not found.") })
	@PatchMapping("{id}")
	public ResponseEntity<?> updateAnyStudentDetails(@Valid @RequestBody SchoolClassDto studentDto,
			@PathVariable String id) {
		return ResponseEntity.ok(classService.updateDetails(id, studentDto));
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
