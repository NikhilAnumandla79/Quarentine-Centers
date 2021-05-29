package com.coding.quarentine.models;

public class Center {
	private int id;
	private String place;
	private int strength;
	public Center() {
		// TODO Auto-generated constructor stub
	}
	
	public Center(String place, int strength) {
		super();
		this.place = place;
		this.strength = strength;
	}
	

	public Center(int id, String place, int strength) {
		super();
		this.id = id;
		this.place = place;
		this.strength = strength;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "Center [id=" + id + ", place=" + place + ", strength=" + strength + "]";
	}
	
	
}
