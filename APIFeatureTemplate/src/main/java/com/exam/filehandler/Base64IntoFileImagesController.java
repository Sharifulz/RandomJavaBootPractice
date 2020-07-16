package com.exam.filehandler;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.payload.StringImageViewModel;
import com.exam.service.IBase64StringToImageService;

@RestController
public class Base64IntoFileImagesController {

	@Value("${image.upload.path}")
	private String uploadDir;
	
	@Autowired
	IBase64StringToImageService imageService;
	
	@PostMapping("/save_images")
	public Map<String, Object> home(HttpServletRequest request, @RequestBody List<StringImageViewModel> viewModel) {
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (viewModel.size()>0) {
			data = imageService.uploadImageFromString(request,viewModel);
		}
		return data;
	} 
	
	@GetMapping("/make_dir")
	public Map<String, Object> makeDir(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		String PATH = request.getServletContext().getRealPath("")+uploadDir;
	    String directoryName = PATH.concat("CDE");
	   // String fileName = id + getTimeStamp() + ".txt";

	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

		
		return data;
	} 
	
	
}
