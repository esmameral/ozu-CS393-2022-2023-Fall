package com.ozu.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ozu.myapp.dto.StudentDTO;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.service.RegistrationService;

@RestController()
@RequestMapping(value = "/students")
public class StudentController {
	@Autowired
	RegistrationService service;
	

	@GetMapping
	public List<Student> getAllStudents() {		
		return service.findAllStudents();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Integer id) {
		StudentDTO s=service.findStudentById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(s);
		 
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(student));
		

	}
	
	//http://localhost:8080/students/204/courses/11
	@PutMapping(value="/{studentId}/courses/{courseId}")
	public String enrollStudentCourse(@PathVariable("courseId") int courseId, 
			@PathVariable("studentId") int studentId) {
		return service.enrollStudentCourse(courseId,studentId);
		
	}

	@DeleteMapping(value = "/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		service.deleteStudent(id);
		return "ok";
	}

}
