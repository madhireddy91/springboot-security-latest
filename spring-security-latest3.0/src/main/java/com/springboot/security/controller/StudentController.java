package com.springboot.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.entity.Student;

@RestController
public class StudentController {
	
	
	private List<Student> students = new ArrayList<>();
	
	@GetMapping("/students")
	public List<Student> students(){
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setFirstName("Kristina");
		s1.setLastName("Markus");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setFirstName("Uma");
		s2.setLastName("Reddy");
		
		students.add(s1);
		students.add(s2);
		
		return students;
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		
		students.add(student);
		return student;
		
	}
	

}
