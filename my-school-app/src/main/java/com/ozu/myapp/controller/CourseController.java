package com.ozu.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.service.CourseService;

@RestController()
@RequestMapping(value = "/courses")
@CrossOrigin
public class CourseController {
	@Autowired
	CourseService service;
	
	
	@GetMapping
	public List<Course> findAll() {
		return service.findAll();
	}
	
	@PostMapping
    public Course save(@RequestBody Course c) {
        return service.saveCourse(c);
    }
	
}
