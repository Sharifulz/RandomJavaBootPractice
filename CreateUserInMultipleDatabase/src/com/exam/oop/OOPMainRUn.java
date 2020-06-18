package com.exam.oop;

public class OOPMainRUn {

	public static void main(String[] args) {
		AnimalClass dog = new DogClass();
		dog.setName("Dog1");
		dog.setDesc("Dog says vow vow");
		AnimalClass cat = new CatClass();
		cat.setName("Cat1");
		cat.setDesc("Cat says meaw meaw");
		
		System.out.println(cat.getDesc());
		

	}

}
