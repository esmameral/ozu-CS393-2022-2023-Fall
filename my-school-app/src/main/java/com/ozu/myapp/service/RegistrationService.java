package com.ozu.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.dao.CourseDAO;
import com.ozu.myapp.dao.StudentDAO;
import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.repository.CourseRepository;

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

	public Course getCourseByCode(String courseCode){
		return courseRepository.findByCode(courseCode);
	}
	
	public List<Course> getMyCourse(String courseCode, int credit){
		return courseRepository.findMyCourses(courseCode,  credit);
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
