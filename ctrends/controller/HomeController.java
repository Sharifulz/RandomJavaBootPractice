package com.ctrends.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@GetMapping("/start")
	public String home() {
		return "<h1 style='color:red; text-align:center;'>Welcome from CTrends KYC App </h1>";
	}
}
