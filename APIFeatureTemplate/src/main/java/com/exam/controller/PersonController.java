package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Person;
import com.exam.service.PersonsService;

@RestController
public class PersonController {
	@Autowired
	PersonsService personService;
	
	@GetMapping("/persons")
	public List<Person> getPersons(){
		return personService.getAllPersons().subList(1, 2);
	}
}
