package com.ozu.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozu.myapp.model.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
