package com.ozu.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
