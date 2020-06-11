package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Person;
import com.exam.service.PersonsService;

@RestController
public class PersonController {
	@Autowired
	PersonsService personService;
	
	@GetMapping("/person")
	public List<Person> getPerson(){
		return personService.getAllPersons().subList(1, 2);
	}
	
	@PostMapping("/personArr")
	public Person getPersonArray(@RequestBody Person person){
		
		/*
		for (int i = 0; i < person.getStrArray().length; i++) {
			System.out.println(person.getStrArray()[i]);
		}
		*/
		System.out.println(person.getAge());
		System.out.println(person.getName());
		System.out.println(person.getSalary());
		return person;
	}
	
	//http://localhost:9099/persons
	@PostMapping("/persons")
	public List<Person> getPersons(@RequestBody List<Person> persons){
		
		for(Person p: persons) {
			System.out.println(p.getName());
			System.out.println(p.getFathersName());
		}
		
		return persons;
	}
	
	/*
	[
	 	{
	    "name":"Shariful Islam",
		"age":25,
		"fathersName":"Shafiqul Islam",
		"mothersName":"Aklima Begum"       
		},
		{
	    "name":"Ariful Islam",
		"age":26,
		"fathersName":"Afiqul Islam",
		"mothersName":"Lima Begum"       
		}
	]
	 */
}
