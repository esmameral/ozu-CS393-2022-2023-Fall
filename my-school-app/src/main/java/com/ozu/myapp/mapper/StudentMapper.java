package com.ozu.myapp.mapper;

import com.ozu.myapp.dto.StudentDTO;
import com.ozu.myapp.model.Student;

public class StudentMapper {
	public static StudentDTO studentToDTO(Student s) {
		StudentDTO dto=new StudentDTO();
		dto.setStudentNumber(s.getId());
		dto.setStudentFullName(s.getName());
		dto.setDepartment(s.getDepartment());
		return dto;
		
	}
}
