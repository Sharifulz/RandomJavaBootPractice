package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//return "<h1 style='color:blue; text-align:center;'>Welcome from CTrends <span style='color:red'>GIS</span> App </h1>";
		return "index.html";
	}
}
