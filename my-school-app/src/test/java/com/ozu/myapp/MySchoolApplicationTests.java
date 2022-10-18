package com.ozu.myapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ozu.myapp.repository.CourseDAO;
import com.ozu.myapp.repository.StudentDAO;

@SpringBootTest
class MySchoolApplicationTests {
	@MockBean
	StudentDAO studentDAO;
	
	@MockBean
	CourseDAO courseDAO;
	
	@Test
	void contextLoads() {
	}

}
