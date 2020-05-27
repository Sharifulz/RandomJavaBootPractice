package com.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.model.Person;


@Service
public class PersonsService {
	
	public List<Person> getAllPersons(){
		List<Person> personsList = new ArrayList<Person>();
		personsList.add(new Person(1, "Shariful Islam",25, "Shafiqul Islam", "Aklima Begum"));
		personsList.add(new Person(2, "Ariful Islam",29, "Shafiul Islam", "Lima Begum"));
		return personsList;
	}
	
}
