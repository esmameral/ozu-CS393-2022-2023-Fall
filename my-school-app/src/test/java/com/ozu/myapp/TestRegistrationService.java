package com.ozu.myapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.service.RegistrationService;

@SpringBootTest
public class TestRegistrationService {
	@Autowired
	RegistrationService service;
	
	@Test
	public void testGetCourseByCode() {
		Course course=service.getCourseByCode("CS105");
		System.out.println(course);
		
		List<Course> list=service.getMyCourse("CS393",6);
		System.out.println(list.size());
	}

}
