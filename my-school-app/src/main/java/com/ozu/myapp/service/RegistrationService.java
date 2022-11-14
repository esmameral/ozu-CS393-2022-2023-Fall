package com.ozu.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.dao.CourseDAO;
import com.ozu.myapp.dao.StudentDAO;
import com.ozu.myapp.model.Course;
import com.ozu.myapp.model.Instructor;
import com.ozu.myapp.model.Student;
import com.ozu.myapp.repository.CourseRepository;
import com.ozu.myapp.repository.InstructorRepository;
import com.ozu.myapp.repository.StudentRepository;

@Service
public class RegistrationService {
	// @Autowired
	StudentDAO studentDAO;

	// @Autowired
	CourseDAO courseDAO;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstructorRepository instructorRepository;
	
	@Autowired
	StudentRepository studentRepository;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public CourseRepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public InstructorRepository getInstructorRepository() {
		return instructorRepository;
	}

	public void setInstructorRepository(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	

	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	public Course getCourseByCode(String courseCode){
		return courseRepository.findByCode(courseCode);
	}
	
	public List<Course> getMyCourse(String courseCode, int credit){
		return courseRepository.findMyCourses(courseCode,  credit);
	}
	
	public Course saveCourse(Course aCourse) {
		return courseRepository.save(aCourse);
	}
	
	public Instructor saveInstructor(Instructor ins) {
		return instructorRepository.save(ins);
	}
	
	public Student saveStudent(Student s) {
		return studentRepository.save(s);
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
