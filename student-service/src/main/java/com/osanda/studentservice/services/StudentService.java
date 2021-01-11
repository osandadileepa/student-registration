package com.osanda.studentservice.services;

import com.osanda.studentservice.enity.Student;
import com.osanda.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student st) {

        return studentRepository.save(st);
    }

    public List<Student> getAllStudents() {

        return this.studentRepository.findAll();
    }
}
