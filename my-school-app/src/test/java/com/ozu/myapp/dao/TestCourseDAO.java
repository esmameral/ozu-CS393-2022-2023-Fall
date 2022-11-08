package com.ozu.myapp.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.myapp.model.Course;

@SpringBootTest
public class TestCourseDAO {
	@Autowired
	CourseDAO courseDAO;
	@Test
	public void testGetCourseByCode() {
		Course c=courseDAO.findByCode("CS105");
		System.out.println(c.getCode()+" "+c.getName());
	}

}
