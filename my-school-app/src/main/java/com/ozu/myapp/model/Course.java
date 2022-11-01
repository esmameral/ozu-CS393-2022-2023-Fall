package com.ozu.myapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_COURSE")
public class Course {
   

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    
    @Column(name="COURSE_NAME",length = 100)
	private String name;
	private String code;
	private int credit;
	
	//Owning side
	//JPA creates a new table named COURSE_STUDENTS for relation.
	//If you need to change default table and column names, you can use 
	//@JoinTable and @JoinColumn
	@ManyToMany
	@JoinTable(name = "REL_COURSE_STUDENT", 
	joinColumns = @JoinColumn(name = "COURSE_ID", 
	referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "STUDENTO_ID", 
	referencedColumnName = "ID"))
	private List<Student> students=new ArrayList<>();
	
	//Owning side
	@ManyToOne
	
	//JPA adds a new column named INSTRUCTOR_ID into INSTRUCTOR table for relation.
	//If you want to change that default column name, you can use @JoinColumn
	@JoinColumn(name = "INS_ID")
	private Instructor instructor;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course() {
		super();
	}

	public Course(String code, String name) {
		this.code=code;
		this.name=name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	 @Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", code=" + code + ", credit=" + credit + "]";
		}

}
