package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.ProcessEmail;

@RestController
public class SendEmailController {

	@Autowired
	ProcessEmail emailService;
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Map<String, Object>> checkEmail(@PathVariable("email") String email){
		Map<String, Object> data = new HashMap<String, Object>();
		ResponseEntity<Map<String,Object>> responseEntity = null;
		data = emailService.sendEmailTo(email);
		
		if (data.get("responseCode").equals("404")) {
			responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
		}else {
			responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
}
