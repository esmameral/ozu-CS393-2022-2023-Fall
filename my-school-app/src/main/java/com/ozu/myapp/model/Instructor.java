package com.ozu.myapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_INSTRUCTOR")
public class Instructor extends Person{
	
	private String roomNumber;
	
	@OneToMany(mappedBy = "instructor")
	private List<Course> courses=new ArrayList<>();
	
	public Instructor() {
		super();
	}

	public Instructor(String name, String roomNumber) {
		super();
		setName(name);
		this.roomNumber=roomNumber;
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + getId() + ", name=" + getName() + "]";
	}

}
