package com.ozu.myapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_STUDENT")
public class Student extends Person {
	private String department;
	
	@ManyToMany(mappedBy ="students" ,cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();

	
	public Student() {
		super();

	}

	public Student(String name, String department) {
		super();
		setName(name);
		this.department = department;
	}
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + getId() + ", name=" + getName() + ", department=" + department + "]";
	}

}
