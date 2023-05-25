package com.crud.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getstudent")
	public ResponseEntity<?> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createStudent(@RequestBody Student student){
		
		return studentService.insertStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id){
	    try {
		return studentService.deleteStudent(id);
	    }catch(NoSuchElementException e) {
	    	return new ResponseEntity<String>("please enter valid Id",HttpStatus.NOT_FOUND);
	    }
	   
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student){
		 try {
				return studentService.updateStudent(id, student);
			    }catch(NoSuchElementException e) {
			    	return new ResponseEntity<String>("please enter valid Id",HttpStatus.NOT_FOUND);
			    }
	}
}
