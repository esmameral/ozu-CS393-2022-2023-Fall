package com.ozu.myapp.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.myapp.dto.InstructorDTO;
import com.ozu.myapp.mapper.InstructorMapper;
import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Instructor;
import com.ozu.myapp.model.Student;

@SpringBootTest
public class TestJPAConfig {
	@Autowired
	StudentService studentService;
	
	@Autowired
	InstructorService instructorService;

	@Autowired
	CourseService courseService;
	
	@Autowired
	InstructorMapper instructorMapper;

	@Test
	public void testMappings() {
		Student s1 = new Student("Nedim", "CS");
		InstructorDTO i1 = new InstructorDTO("Alper", "456");
		studentService.save(s1);
		instructorService.save(i1);
		assertTrue(s1.getId()!=0);
		System.out.println(s1);
		System.out.println(i1);

		Course c1 = new Course("CS114", "C++", 6);
		courseService.saveCourse(c1);
		c1.getStudents().add(s1);
		s1.getCourses().add(c1);
		Instructor instructor=instructorMapper.instructorDTOToEntity(i1);
		c1.setInstructor(instructor);
		instructor.getCourses().add(c1);

		instructorService.save(instructorMapper.instructorEntityToDTO(instructor));
		studentService.save(s1);

		System.out.println(c1);
	}

	@Test
	public void testJPQL1() {
		List<Student> list = studentService.getAllByCourseCode("CS101");
		assertTrue(list.size() >= 0);
		for (Student student : list) {
			System.out.println(student);
		}

	}
	
	@Test
	public void testTrx() {
		studentService.transactionSample();
	}
	
	
	
	@Test
	public void testJPQLQuery() {
		List<Student> list = studentService.findMyStudents("CS317");
		assertTrue(list.size() >= 0);
		for (Student student : list) {
			System.out.println(student);
		}

	}

	@Test
	@Transactional
	public void testCascade() {
		Student student1 = new Student("Canan Demir", "IE");
		Student student2 = new Student("Kaan Karaca", "CS");
		Instructor ins1 = new Instructor("Cihan Kayacan", "141");

		Course course1 = new Course("CS105", "Object Oriented Programming", 6);
		Course course2 = new Course("CS383", "Developing Backend Applications with Spring Framework", 4);

		course1.getStudents().add(student1);
		student1.getCourses().add(course1);

		course2.getStudents().add(student2);
		student2.getCourses().add(course2);

		course1.setInstructor(ins1);
		ins1.getCourses().add(course1);

		instructorService.save(instructorMapper.instructorEntityToDTO(ins1));
		courseService.saveCourse(course2);

	}
	
	
}
