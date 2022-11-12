package com.ozu.exam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "owner",cascade={CascadeType.ALL})
	private List<PurchaseOrder> orders=new ArrayList<>();
	
	//Other methods are not shown
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<PurchaseOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<PurchaseOrder> orders) {
		this.orders = orders;
	}
	
}
