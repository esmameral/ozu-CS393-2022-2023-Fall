package com.ozu.myapp.repository;

import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Student;
@Repository
public interface StudentDAO {
	public Student findById(int id);

	public void save(Student aStudent);

}
