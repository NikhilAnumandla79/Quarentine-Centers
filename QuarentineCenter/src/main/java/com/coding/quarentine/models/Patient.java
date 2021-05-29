package com.coding.quarentine.models;

public class Patient {
	private int id;
	private String name;
	private int age;
	private int centerId;
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public Patient(String name, int age, int centerId) {
		super();
		this.name = name;
		this.age = age;
		this.centerId = centerId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	
	
}
