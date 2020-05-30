package com.exam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadPropertiesFile {
	@Value("${application.name}")
	String appName;
	@Value("${application.owner}")
	String appOwner;
	@Value("${application.desc}")
	String appDesc;
	
	String name="";
	String email="";
	
	@GetMapping("/props")
	public ResponseEntity<String> readProperties() {
		String returnString = appName+" "+ appOwner+" "+ appDesc + "---"+ name+ "---" +email;
		return new ResponseEntity<>(returnString,HttpStatus.PRECONDITION_FAILED);
	}
	
	
}
