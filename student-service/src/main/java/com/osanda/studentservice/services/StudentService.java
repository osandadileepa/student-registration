package com.osanda.studentservice.services;

import com.osanda.studentservice.dto.StudentDto;
import com.osanda.studentservice.enity.Student;
import com.osanda.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;

	public Student saveStudent(StudentDto dto) {

		return studentRepository.save(new Student(dto));
	}

	public List<Student> getAllStudents() {

		return this.studentRepository.findAll();
	}

	public Student getStudentById(String id) {

		return this.studentRepository.findById(id).get();
	}

	public void deleteByID(String id) {
		this.studentRepository.deleteById(id);
		log.info("Student deleted with id {}", id);
	}

}
