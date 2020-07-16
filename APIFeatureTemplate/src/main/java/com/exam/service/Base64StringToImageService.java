package com.exam.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exam.payload.StringImageViewModel;

@Service
public class Base64StringToImageService implements IBase64StringToImageService {

	@Value("${image.upload.path}")
	private String uploadDir;
	
	@Override
	public Map<String, Object> uploadImageFromString(HttpServletRequest request, List<StringImageViewModel> viewModel) {
			Map<String, Object> data = new HashMap<String, Object>();
			List<String> message = new ArrayList<>();
			boolean isFileSaved = false;
			
			int count = 1;
			for (StringImageViewModel surveyImage : viewModel) {
				if (surveyImage.getImageString()!=null && !surveyImage.getImageString().equals("")) {
					String path = request.getServletContext().getRealPath("")+uploadDir+ File.separator;
					byte[] imageByte =Base64.getDecoder().decode(surveyImage.getImageString());
					InputStream targetStream = new ByteArrayInputStream(imageByte);
					isFileSaved = saveFile(targetStream, path);
					if (isFileSaved) {
						message.add("Save image "+ count);
						count++;
					}
				}
			}
			data.put("message",message);
			return data;
	}
	
	public boolean saveFile(InputStream inputStream, String path) {
		try {
			OutputStream outputStream = new FileOutputStream(new File(path));
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
