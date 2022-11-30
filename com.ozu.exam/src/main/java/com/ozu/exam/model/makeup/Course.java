package com.ozu.exam.model.makeup;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(name="COURSE_NAME",length = 100)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "REL_COURSE_STUDENT", 
	joinColumns = @JoinColumn(name = "COURSE_ID", 
	referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", 
	referencedColumnName = "ID"))
	private List<Student> students=new ArrayList<>();
}
