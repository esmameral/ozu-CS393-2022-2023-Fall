package com.ozu.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozu.myapp.repository.StudentRepository;
import com.student.model.Enrollment;
import com.student.model.Score;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public double calculateGradeFor(int studentId, String courseCode) {
		Student student = studentRepo.findById(studentId);

		for (Enrollment enrollment : student.getEnrollments()) {
			if (enrollment.getCourse().getCode().equals(courseCode)) {
				return calculateGrade(enrollment);
			}
		}
		return 0;
	}
	
	
	private double calculateGrade(Enrollment enrollment) {
		double grade = 0;
		for (Score score : enrollment.getScores()) {
			grade += score.getValue() * score.getAssessment().getWeight() / 100.0;
		}
		return grade;
	}

	public String calculateLetterGradeFor(double grade) {

		if (grade >= 90)
			return "A";
		else if (grade >= 80)
			return "A-";
		else if (grade >= 75)
			return "B+";
		else if (grade >= 70)
			return "B";
		else if (grade >= 65)
			return "B-";
		else if (grade >= 60)
			return "C+";
		else if (grade >= 56)
			return "C";
		else if (grade >= 51)
			return "C-";
		else if (grade >= 46)
			return "D+";
		else if (grade >= 40)
			return "D";
		else
			return "F";
	}

}
