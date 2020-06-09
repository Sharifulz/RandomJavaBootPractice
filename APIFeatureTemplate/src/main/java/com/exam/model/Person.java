package com.exam.model;

public class Person {
	
	int id;
	String name;
	int age;
	String fathersName;
	String mothersName;
	
	String[] strArray;
	
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
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String[] getStrArray() {
		return strArray;
	}
	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}
	public Person(int id, String name, int age, String fathersName, String mothersName) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
	}
	public Person() {}
	
	
	
}
