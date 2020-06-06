package com.ctrends.service;

import java.util.List;
import java.util.Map;

import com.ctrends.model.UsersModel;

public interface IPasswordService {
	
	public Map<String, Object> savePassword(Map<String, Object> data);
	
	public Map<String, Object> authenticateUser(Map<String, Object> data);
	
	public Map<String, Object> resetPassword(String to, List<UsersModel> user);
	
	public Map<String, Object> sendPAsswordToMail(String to, String subject, String body);
	
}
