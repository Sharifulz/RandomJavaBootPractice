package com.exam.interfacetest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestInterfaceController {
	
	@Autowired
	@Qualifier("adds")
	ICalculatorService calculator;
	
	@Autowired
	@Qualifier("subs")
	ICalculatorService calculator2;
	
	@GetMapping("/ok1")
	public String ok() {
		int res = calculator.calc(8, 6);
		System.out.println("result is -------------------------------------"+res);
		return String.valueOf(res);
	}
	
	@GetMapping("/ok2")
	public String ok2() {
		
		int res = calculator2.calc(8, 6);
		System.out.println("result is -------------------------------------"+res);
		return String.valueOf(res);
	}
	
}
