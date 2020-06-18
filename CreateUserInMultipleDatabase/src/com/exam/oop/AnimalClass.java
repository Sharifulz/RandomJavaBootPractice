package com.exam.oop;

public class AnimalClass {

	String name;
	String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public AnimalClass(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public AnimalClass() {
		super();
	}
	
	
}
