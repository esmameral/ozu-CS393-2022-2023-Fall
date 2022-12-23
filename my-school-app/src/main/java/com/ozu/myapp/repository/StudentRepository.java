package com.ozu.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	@Query("Select s from Student s inner join s.courses c where c.code=?1")
	public List<Student> findMyStudents(String code);
	
	
	public List<Student> findByDepartmentIn(List<String> depList);

	public List<Student> findByCoursesCode(String code);
	
}
