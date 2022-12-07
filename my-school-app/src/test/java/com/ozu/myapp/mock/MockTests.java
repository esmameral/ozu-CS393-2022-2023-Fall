package com.ozu.myapp.mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ozu.myapp.dao.CourseDAO;
import com.ozu.myapp.dao.StudentDAO;
import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.service.StudentService;

@SpringBootTest
class MockTests {
	@MockBean
	StudentDAO studentDAO;
	
	@MockBean
	CourseDAO courseDAO;
	
	@Autowired
	StudentService service;
			
	@Test
	void mockTest() {
		service.setCourseDAO(courseDAO);
		service.setStudentDAO(studentDAO);
		
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
		Course aCourse = new Course("CS391", "Web Programming",4);

		return aCourse;
	}

	private Student getDummyStudent() {
		Student aStudent = new Student("Kerem","CS");
		Course course1 = new Course("CS393", "Spring Framework",4);
		Course course2 = new Course("CS101", "Introduction to Programming",6);
		aStudent.getCourses().add(course1);
		aStudent.getCourses().add(course2);
		return aStudent;
	}
	
	

}
