package com.ozu.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozu.myapp.model.Student;
import com.ozu.myapp.service.RegistrationService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	@Autowired
	RegistrationService service;
	

	@GetMapping
	//@GetMapping(value = "/students")
	public List<Student> getAllStudents() {		
		return service.findAllStudents();
	}
	
	@GetMapping(value = "/{id}")
	//@GetMapping(value = "/students/{id}")
	public String getStudent(@PathVariable("id") Integer id) {
		return "hello "+id;
	}
	
	@PostMapping
	//@PostMapping(value = "/students")
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);

	}
	

	@DeleteMapping(value = "/{id}")
	//@DeleteMapping(value = "/students/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		service.deleteStudent(id);
		return "ok";
	}

}
