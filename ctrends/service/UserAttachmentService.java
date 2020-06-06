package com.ctrends.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.dao.IUserAttachmentsDao;
import com.ctrends.model.UserAttachmentsModel;
import com.ctrends.model.UsersModel;

@Service
public class UserAttachmentService implements IUserAttachmentService {

	@Autowired
	IUserAttachmentsDao userAttachmentsDao;
	
	@Autowired
	IUserService userService;
	
	//-- username, personName,fileContent
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveAttachments(List<UserAttachmentsModel> userAttachments) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<UserAttachmentsModel> attachmentList = new ArrayList<>();
		List<List<String>> message = new ArrayList<>();
		boolean isSaved = true;
				
		int size = userAttachments.size();
		for (int i = 0; i < size; i++) {
			Map<String, Object> validationResult = new HashMap<String, Object>();
			validationResult = this.attachmentValidityCheck(userAttachments.get(i));
			if (validationResult.get("status").equals(true)) {
				//-------- has error, return --------------------------
				isSaved = false;
				attachmentList.add(userAttachments.get(i));
				message.add((List<String>) validationResult.get("message"));
			}else {
				//-------- save ---------------------------------------
				UserAttachmentsModel userAttachment = new UserAttachmentsModel();
				try {
					userAttachment = userAttachmentsDao.save(userAttachments.get(i));
					attachmentList.add(userAttachment);
					message.add((List<String>) validationResult.get("message"));
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}
		}
		
		if (isSaved) {
			data.put("data", attachmentList);
			data.put("message", message);
			data.put("responseCode", "200");
			data.put("status", "successful");
		}else {
			data.put("data", attachmentList);
			data.put("message", message);
			data.put("responseCode", "412");
			data.put("status", "failure");
		}
		
		return data;
	}

	@Override
	public Map<String, Object> updateUserAttachments(String username, UserAttachmentsModel userAttachment) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<UserAttachmentsModel> userAttachmentList = userAttachmentsDao.getUserAttachmentListByUsernameAndFileName(username, userAttachment.getFileName());
		
		if (userAttachmentList.size()>0) {
			userAttachment.setId(userAttachmentList.get(0).getId());
			UserAttachmentsModel updatedAttachment = userAttachmentsDao.save(userAttachment);
			data.put("data", updatedAttachment);
			data.put("message", "User Attachment updated");
			data.put("responseCode", "200");
			data.put("status", "successful");
		}else {
			data.put("data", "");
			data.put("message", "Failed to update user Attachment");
			data.put("responseCode", "400");
			data.put("status", "failure");
		}
			
		return data;
	}

	@Override
	public Map<String, Object> deleteUserAttachments(String username, UserAttachmentsModel userAttachment) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<UserAttachmentsModel> userAttachmentList = userAttachmentsDao.getUserAttachmentListByUsernameAndFileName(username, userAttachment.getFileName());
		
		if (userAttachmentList.size()>0) {
			userAttachment.setId(userAttachmentList.get(0).getId());
			userAttachmentsDao.delete(userAttachment);
			data.put("data", "");
			data.put("message", "User Attachment deleted");
			data.put("responseCode", "200");
			data.put("status", "successful");
		}else {
			data.put("data", "");
			data.put("message", "Failed to delete user Attachment");
			data.put("responseCode", "400");
			data.put("status", "failure");
		}
		
		return null;
	}
	
	public Map<String, Object> attachmentValidityCheck(UserAttachmentsModel userAttachments) {
		
		boolean isValidationError = false;
		List<String> errorMsg = new ArrayList<>();
		UsersModel userByUsername = null;
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (userAttachments.getUsername()==null || userAttachments.getUsername().equals("")) {
			isValidationError=true;
			errorMsg.add("Username not found for save attachment");
		}else {
			userByUsername = userService.getUserByUsername(userAttachments.getUsername());
			if(userByUsername==null) {
				isValidationError=true;
				errorMsg.add("Username not found for save attachment");
			}
		}
		if (userAttachments.getPersonName()==null || userAttachments.getPersonName().equals("")) {
			isValidationError=true;
			errorMsg.add("Person Name not found for save attachment");
		}
		if (userAttachments.getFileContent()==null || userAttachments.getFileContent().equals("")) {
			isValidationError=true;
			errorMsg.add("File content not found for save attachment");
		}
		
		data.put("status", isValidationError);
		
		if (isValidationError) {
			data.put("message", errorMsg);
		}else {
			errorMsg.add("All data are valid found!");
			data.put("message", errorMsg);
		}

		return data;
	}

}
