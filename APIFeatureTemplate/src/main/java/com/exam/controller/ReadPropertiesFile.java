package com.exam.controller;

import org.springframework.beans.factory.annotation.Value;
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
	
	@GetMapping("/props")
	public String readProperties() {
		return appName+" "+ appOwner+" "+ appDesc;
	}
	
	
}
