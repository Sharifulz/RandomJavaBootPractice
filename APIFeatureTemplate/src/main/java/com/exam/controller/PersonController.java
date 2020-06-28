package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.InvoiceModel;
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
	public Person getPersonArray(@RequestBody Person person, InvoiceModel invoice){
		
		/*
		for (int i = 0; i < person.getStrArray().length; i++) {
			System.out.println(person.getStrArray()[i]);
		}
		*/
		System.out.println(person.getName());
		System.out.println("---------------------------------");
		//System.out.println(invoice.getInvoicenumber());
		return person;
	}
	
	@PostMapping("/map")
	public String getMap(@RequestBody Map<String, Object> requestMap){
		
		requestMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered((map -> {
			System.out.println("Key ---------> "+ map.getKey() + " ----- Value -----------> "+ map.getValue().toString());
		}));
		
		return "Map printed";

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
