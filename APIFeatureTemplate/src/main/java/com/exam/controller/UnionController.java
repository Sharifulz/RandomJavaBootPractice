package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.GisUnionModel;
import com.exam.service.IUnionsService;

@RestController
public class UnionController {
	
	@Autowired
	IUnionsService unionService;
	
	//http://localhost:9099/unions?page=1&size=2
	//http://localhost:9099/unions?page=2&size=10&sort=unionName
	//http://localhost:9099/unions?page=2&limit=20
	//http://localhost:9099/unions?name=K&sort=name&name.dir=desc
	@GetMapping("/unions")
	public Page<GisUnionModel> getUserOnePage(Pageable pageable){
		return unionService.findAll(pageable);
	}
}
