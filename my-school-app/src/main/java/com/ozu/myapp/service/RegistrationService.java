package com.ozu.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.repository.CourseDAO;
import com.ozu.myapp.repository.StudentDAO;

@Service
public class RegistrationService {
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	CourseDAO courseDAO;
	
	
public boolean enrollCourse(String courseCode, int studentId) {
	
	
	Student aStudent=studentDAO.findById(studentId);
	Course aCourse=courseDAO.findByCode(courseCode);
	aStudent.getCourses().add(aCourse);
	studentDAO.save(aStudent);
	
	return false;
}


public boolean dropCourse(String courseCode, int studentId) {
	return false;
}

}
