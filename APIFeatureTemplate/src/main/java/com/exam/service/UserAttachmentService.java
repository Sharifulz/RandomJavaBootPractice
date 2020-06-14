package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.IUserAttachmentsDao;
import com.exam.model.UserAttachmentsModel;

@Service
public class UserAttachmentService implements IUserAttachmentService {

	@Autowired
	IUserAttachmentsDao userAttachmentsDao;
	
	//-- username, personName,fileContent
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveAttachments(List<UserAttachmentsModel> userAttachments) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		List<UserAttachmentsModel> attachmentList = new ArrayList<>();
		List<String> message = new ArrayList<>();
		
		int size = userAttachments.size();
		for (int i = 0; i < size; i++) {
			Map<String, Object> validationResult = new HashMap<String, Object>();
				// has validation error
				data.put("data", userAttachments);
				data.put("message", validationResult.get("message"));
				data.put("responseCode", "412");
				data.put("status", "failure");
				return data;	
		}
		
		for (int i = 0; i < size; i++) {
			UserAttachmentsModel userAttachment = new UserAttachmentsModel();
			try {
				userAttachment = userAttachmentsDao.save(userAttachments.get(i));
				attachmentList.add(userAttachment);
			} catch (Exception e) {
				message.add(e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		
			data.put("data", attachmentList);
			data.put("message", message);
			data.put("responseCode", "200");
			data.put("status", "successful");
		
		
		return data;
	}

}
