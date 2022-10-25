package com.ozu.myapp;

import static org.mockito.Mockito.times;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.repository.CourseDAO;
import com.ozu.myapp.repository.StudentDAO;
import com.ozu.myapp.service.RegistrationService;

@SpringBootTest
class MySchoolApplicationTests {
	@MockBean
	StudentDAO studentDAO;
	
	@MockBean
	CourseDAO courseDAO;
	
	@Autowired
	RegistrationService service;
	
	@Test
	void contextLoads() {
		Student aStudent = getDummyStudent();
		Course aCourse = getDummyCourse();
		Mockito.when(studentDAO.findById(1)).thenReturn(aStudent);
		Mockito.when(courseDAO.findByCode("CS391")).thenReturn(aCourse);
		int count=aStudent.getCourses().size();
		System.out.println("initial count:"+count);
		service.enrollCourse("CS391", 1);
		int newCount=aStudent.getCourses().size();
		System.out.println("new count:"+newCount);

		assertTrue(newCount==count+1);
		Mockito.verify(studentDAO,times(1)).findById(1);	
		Mockito.verify(courseDAO,times(1)).findByCode("CS391");
		
	}
	
	private Course getDummyCourse() {
		Course aCourse = new Course("CS391", "Web Programming");

		return aCourse;
	}

	private Student getDummyStudent() {
		Student aStudent = new Student(1, "Kerem");
		Course course1 = new Course("CS393", "Spring Framework");
		Course course2 = new Course("CS101", "Introduction to Programming");
		aStudent.getCourses().add(course1);
		aStudent.getCourses().add(course2);
		return aStudent;
	}

}
