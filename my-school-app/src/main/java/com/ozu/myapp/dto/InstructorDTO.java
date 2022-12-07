package com.ozu.myapp.dto;

public class InstructorDTO {
	private String name;
	private String officeNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public InstructorDTO() {
		super();
	}

	public InstructorDTO(String name, String officeNumber) {
		super();
		this.name = name;
		this.officeNumber = officeNumber;
	}
}
