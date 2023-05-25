package com.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.repo.StudentRepo;
@Service
@Transactional
public class StudentServiceImpl  implements StudentService{

@Autowired
private StudentRepo studentRepo;
	
	//getting list of student
	@Override
	public ResponseEntity<?> getAllStudent() {
		List<Student> studentlist = studentRepo.findAll();
		return new ResponseEntity<List<Student>>(studentlist,HttpStatus.OK);
	}
    //create  new student
	@Override
	public ResponseEntity<?> insertStudent(Student student) {
		
		Student persistedStudent=studentRepo.save(student);
	
		return new ResponseEntity<Student>(persistedStudent,HttpStatus.OK);
	}
    //update details of student
	@Override
	public ResponseEntity<?> updateStudent(Long id, Student student) {
		Student singleStudent = studentRepo.findById(id).orElseThrow();
		singleStudent=studentRepo.save(student);
		return new ResponseEntity<Student>(singleStudent,HttpStatus.OK);
	}
   // delete existing student
	@Override
	public ResponseEntity<?> deleteStudent(Long id) {
	   Student student = studentRepo.findById(id).orElseThrow();
	   studentRepo.deleteById(id);
		return new ResponseEntity<String>("Student Deleted Succesfully",HttpStatus.OK);
	}

}
