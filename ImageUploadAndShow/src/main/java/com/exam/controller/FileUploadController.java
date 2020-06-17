package com.exam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.model.UploadFileResponse;

@RestController
@RequestMapping("/file")
public class FileUploadController {
private static String UPLOAD_DIR ="uploads";
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public UploadFileResponse upload(@RequestParam("file") MultipartFile file, @RequestParam("name") String fileName, HttpServletRequest request) {
		
		System.out.println("------------------------- > "+ fileName);
		UploadFileResponse res =  null;
		try {
			//String filename = "name1.jpg";
			//String filename = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("")+UPLOAD_DIR+ File.separator+fileName;
			saveFile(file.getInputStream(), path);
			res = new UploadFileResponse(fileName, "http://192.168.100.54:9098/uploads/eq.jpg", "PNG", 100);
			//printIpInfo();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void saveFile(InputStream inputStream, String path) {
		try {
			OutputStream outputStream = new FileOutputStream(new File(path));
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
