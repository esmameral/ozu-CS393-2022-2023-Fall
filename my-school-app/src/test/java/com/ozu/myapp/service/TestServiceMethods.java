package com.ozu.myapp.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.myapp.model.Course;

@SpringBootTest
public class TestServiceMethods {
	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;
	
	@Test
	public void testAddStudentToCourse() {
		studentService.enrollCourse(607,202);
	}
	
	@Test
	void testGetCourses() {
		List<Course> list= courseService.findAll();
		for (Course course : list) {
			System.out.println(course.getName());
		}
		assertTrue(list.size()>0);
		Course newCourse = new Course("CS101","programming",6);
		
		courseService.saveCourse(newCourse);
		assertTrue(newCourse.getId()>0);
		
		List<Course> list2= courseService.findAll();
		for (Course course : list2) {
			System.out.println(course.getName());
		}
		assertTrue(list2.size()==list.size()+1);
		
		
	}
}
