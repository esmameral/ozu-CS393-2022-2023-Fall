package com.ozu.myapp.dao;

import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Course;
@Repository
public interface CourseDAO {
	public Course findByCode(String code);

}
