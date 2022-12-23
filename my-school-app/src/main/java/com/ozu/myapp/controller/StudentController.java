package com.ozu.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozu.myapp.dto.StudentDTO;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController()
@RequestMapping(value = "/students")
@CrossOrigin
public class StudentController {
	@Autowired
	StudentService service;

	@GetMapping
	public List<Student> getAll() {
	    return service.findAll();
	}
	
	@GetMapping(value="/engineers")
	public List<Student> getAllEngineeringStudents() {
		return service.findAllEngineeringStudents();
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Find student by ID", description = "Returns a single student")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = StudentDTO.class))),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Integer id) {
		StudentDTO s = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	
	
	@PostMapping
	@Operation(summary = "Create a new student", description = "Save new student's info into database")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "successful operation") })
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(student));

	}

	// http://localhost:8080/students/204/courses/11
	@PutMapping(value = "/{studentId}/courses/{courseId}")
	public String enrollStudentCourse(@PathVariable("courseId") int courseId,
			@PathVariable("studentId") int studentId) {
		return service.enrollCourse(courseId, studentId);

	}
	
	@GetMapping(value = "/{code}/students")
	public List<Student> getStudentsByCourseCourse(@PathVariable("code") String courseCode) {
		return service.getAllByCourseCode(courseCode);

	}

	@DeleteMapping(value = "/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		service.delete(id);
		return "ok";
	}

}
