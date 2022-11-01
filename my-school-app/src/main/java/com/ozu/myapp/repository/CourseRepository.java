package com.ozu.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	Course findByCode(String code);
	
	@Query("select c from Course c where c.code = ?1 or c.credit=?2")
	List<Course> findMyCourses(String code, int credit);

}
