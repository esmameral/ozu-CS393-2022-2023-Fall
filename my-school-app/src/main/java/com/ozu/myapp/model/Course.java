package com.ozu.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COURSE")
public class Course {
    @Id
	private int id; 
    @Column(name="COURSE_NAME",length = 100)
	private String name;
	private String code;
	
	private int credit;
	

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



}
