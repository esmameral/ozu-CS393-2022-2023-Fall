package com.ozu.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.model.Course;
import com.ozu.myapp.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public CourseRepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course getCourseByCode(String courseCode) {
		return courseRepository.findByCode(courseCode);
	}

	public List<Course> getMyCourse(String courseCode, int credit) {
		return courseRepository.findMyCourses(courseCode, credit);
	}

	public Course saveCourse(Course aCourse) {
		return courseRepository.save(aCourse);
	}

	
	public boolean dropCourse(String courseCode, int studentId) {
		return false;
	}

    

	
}
