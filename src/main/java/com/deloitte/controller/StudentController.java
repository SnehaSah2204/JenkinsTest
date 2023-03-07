package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.model.Student;
import com.deloitte.repository.StudentRepository;

@RestController
@CrossOrigin

@RequestMapping("/students")
public class StudentController {

	
	@Autowired
	private StudentRepository repository;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getStudent(){
		List<Student> students =repository.findAll();
		return ResponseEntity.ok(students);
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student newStudent=repository.save(student);
		return ResponseEntity.ok(newStudent);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable String id){
		repository.deleteById(id);
		List<Student> students =repository.findAll();
		return ResponseEntity.ok(students);
	}
}
