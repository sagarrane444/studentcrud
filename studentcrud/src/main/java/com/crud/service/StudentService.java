package com.crud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.entity.Student;

public interface StudentService {

	ResponseEntity<?> getAllStudent();
	ResponseEntity<?> insertStudent(Student student);
	ResponseEntity<?> updateStudent(Long id, Student student);
	ResponseEntity<?> deleteStudent(Long id);
}
