package com.ozu.myapp.repository;

import com.ozu.myapp.model.Student;

public interface StudentRepository {
	public Student findById(int id);
}
