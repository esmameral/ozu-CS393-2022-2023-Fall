package com.ozu.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
