package com.ozu.myapp.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Instructor;
import com.ozu.myapp.model.Student;

@SpringBootTest
public class TestRegistrationService {
	@Autowired
	RegistrationService service;

	@Test
	public void testGetCourseByCode() {
		Course course = service.getCourseByCode("CS105");
		System.out.println(course);

		List<Course> list = service.getMyCourse("CS393", 6);
		System.out.println(list.size());
	}

	@Test
	public void testMappings() {
		Student s1 = new Student("Nedim", "CS");
		Instructor i1 = new Instructor("Alper","456");
		service.saveStudent(s1);
		service.saveInstructor(i1);
		System.out.println(s1);
		System.out.println(i1);
		
		Course c1=new Course("CS114","C++",6);
		service.saveCourse(c1);
		c1.getStudents().add(s1);
		s1.getCourses().add(c1);
		c1.setInstructor(i1);
		i1.getCourses().add(c1);
		
		service.saveInstructor(i1);
		service.saveStudent(s1);
		
		System.out.println(c1);
	}

	
	@Test
	public void testCascade() {
		Student student1 = new Student("Canan Demir", "IE");
		Student student2 = new Student("Kaan Karaca", "CS");
		Instructor ins1 = new Instructor("Cihan Kayacan","141");
		
		Course course1=new Course("CS105","Object Oriented Programming",6);
		Course course2=new Course("CS383","Developing Backend Applications with Spring Framework",4);
		
		course1.getStudents().add(student1);
		student1.getCourses().add(course1);
		
		course2.getStudents().add(student2);
		student2.getCourses().add(course2);
		
		course1.setInstructor(ins1);
		ins1.getCourses().add(course1);
		
		
		service.saveInstructor(ins1);
		service.saveCourse(course2);

	}
}
