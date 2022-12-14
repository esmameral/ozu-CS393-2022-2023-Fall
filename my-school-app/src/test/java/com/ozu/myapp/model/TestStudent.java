package com.ozu.myapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Student;

class TestStudent {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("@BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}

	@Test
	void testStudentConstructor() {
		Student firstStudent=new Student();
		firstStudent.setId(123);
		firstStudent.setName("Eren");
		assertEquals("Eren",firstStudent.getName() );
		
		Student secondStudent=new Student("Arda","CS");
		assertEquals("Arda",secondStudent.getName());
		assertTrue(secondStudent.getDepartment().equals("CS"));
	}
	@Test
	void testStudentRegisterCourse() {
		Student aStudent=new Student("Arda","CS");
		Course course1=new Course("CS202","Databases",4);
		Course course2=new Course("CS393","Spring",4);
		assertTrue(aStudent.getCourses().size()==0);
		
		aStudent.getCourses().add(course1);
		assertTrue(aStudent.getCourses().size()==1);
		aStudent.getCourses().add(course2);
		assertTrue(aStudent.getCourses().size()==2);
		
		assertEquals("CS202", aStudent.getCourses().get(0).getCode() );
		assertEquals("CS393", aStudent.getCourses().get(1).getCode() );
		
		
	
	}

}
