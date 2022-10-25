package com.ozu.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.repository.CourseDAO;
import com.ozu.myapp.repository.CourseRepository;
import com.ozu.myapp.repository.StudentDAO;

@Service
public class RegistrationService {
	// @Autowired
	StudentDAO studentDAO;

	// @Autowired
	CourseDAO courseDAO;

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	public Course save(Course aCourse) {
		return courseRepository.save(aCourse);
	}

	public Student enrollCourse(String courseCode, int studentId) {

		Student aStudent = studentDAO.findById(studentId);
		Course aCourse = courseDAO.findByCode(courseCode);
		// do business logic
		aStudent.getCourses().add(aCourse);
		studentDAO.save(aStudent);

		return aStudent;
	}

	public boolean dropCourse(String courseCode, int studentId) {
		return false;
	}

}
