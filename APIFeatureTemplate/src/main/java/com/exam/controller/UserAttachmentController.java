package com.exam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.model.Person;
import com.exam.service.IUserAttachmentService;

import antlr.StringUtils;

@RestController
public class UserAttachmentController {
	 
	@Autowired
	IUserAttachmentService userAttachmentService;

	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> addUserAttachment(@RequestParam("file") MultipartFile file) throws IOException {
		
		//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//Path path = Paths.get( + fileName);
		
		Map<String, Object> data = new HashMap<String, Object>();
		ResponseEntity<String> responseEntity = null;
		File converteFile = new File("C:\\Users\\shariful\\Desktop\\ImageAsset", file.getOriginalFilename());
				converteFile.createNewFile();
		
		FileOutputStream fout = new FileOutputStream(converteFile);
		fout.write(file.getBytes());
		fout.close();
		System.out.println("------------------------ ");
		responseEntity = new ResponseEntity<String>("File Uploaded Successful", HttpStatus.UNAUTHORIZED);
		
		return responseEntity;
	}	
	
}
