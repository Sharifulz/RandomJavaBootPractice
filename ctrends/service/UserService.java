package com.ctrends.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ctrends.dao.IUserDao;
import com.ctrends.model.PasswordModel;
import com.ctrends.model.UsersModel;
import com.ctrends.util.IEncoderDecoder;

@Service
public class UserService implements IUserService {

	private static final String EMAIL_PATTERN_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IPasswordService passwordService;
	
	@Autowired
	IEncoderDecoder encoderDecoder;
	
	@Override
	public UsersModel getUserByUsername(String username) {
		List<UsersModel> userlist = userDao.getUserByUsername(username);
		if (userlist.size()>0) {
			return userlist.get(0);
		}
		return null;
	}

	@Override
	public Map<String, Object> saveUser(UsersModel user) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<String> errorMsg = new ArrayList<>();
		boolean isDuplicateFound = false;
		boolean isInvalidDataFound = false;
		List<UsersModel> existingUsername = null;
		List<UsersModel> existingEmail = null;
		List<UsersModel> existingMobile = null;
		String userName = null;
		String password = null;
		
		// Validation Username
		if (user.getUsername()==null ||user.getUsername().equals("")) {
			userName = "CTS"+Long.toString(System.currentTimeMillis());
			user.setUsername(userName);
			//isInvalidDataFound = true;
			//errorMsg.add("Username is not Given");
		}else {
			existingUsername = userDao.getUserByUsername(user.getUsername());
			if (existingUsername.size()>0) {
				isDuplicateFound= true;
				errorMsg.add("Duplicate Username found. ");
			}
		}
		
		Pattern emailPattern = Pattern.compile(EMAIL_PATTERN_REGEX);
		Matcher emailMatcher = null;
		
		// Validation Email
		if (user.getEmail()==null || user.getEmail().equals("")) {
			isInvalidDataFound = true;
			errorMsg.add("Email is not Given");
		}else {
			emailMatcher = emailPattern.matcher(user.getEmail());
			boolean ismatched = emailMatcher.find();
			existingEmail = userDao.getUserByEmail(user.getEmail());
			if (existingEmail.size()>0) {
				isDuplicateFound= true;
				errorMsg.add("Duplicate Email found. ");
			}else if(!ismatched) {
				isInvalidDataFound = true;
				errorMsg.add("Email address is invalid");
			}else {
				password = RandomStringUtils.random( 11, PASSWORD_CHAR );
				String subject = "Password Reset Code";
				String body = "Your request for password reset is approved.<br/> Username : <span style='color:red'>"
								+userName+"</span> <br/> Password : "
										+ " <span style='color:green'>"+password+"</span>";
				Map<String, Object> data2 = new HashMap<String, Object>();
				
				data2 = passwordService.sendPAsswordToMail(user.getEmail(), subject, body);
				
				if (data2.get("responseCode").equals("404")) {
					isInvalidDataFound = true;
					errorMsg.add((String) data2.get("message"));
				}
			}
		}
		// Validation Mobile Number
		if (user.getMobile()==null || user.getMobile().equals("")) {
			isInvalidDataFound = true;
			errorMsg.add("Mobile Number is not Given");
		}else {
			existingMobile =  userDao.getUserByMobile(user.getMobile());
			if (existingMobile.size()>0) {
				isDuplicateFound= true;
				errorMsg.add("Duplicate Mobile number found. ");
			}else if(!user.getMobile().matches("\\d{10}")){
				isInvalidDataFound = true;
				errorMsg.add("Phone number is invalid, required 10 number");
			}
		}
		
		if (isDuplicateFound || isInvalidDataFound) {
			//data.put("data", user);
			data.put("message", errorMsg);
			data.put("responseCode", "412");
			data.put("status", "failure");
		}else {
			UsersModel userModel = userDao.save(user);
			//----------- Set User Password
			if (userModel!=null) {
				Map<String, Object> passwordData = new HashMap<String, Object>();
				passwordData.put("user", userModel);
				PasswordModel pwdModel = new PasswordModel();
				pwdModel.setPwd(encoderDecoder.encodeString(password, ""));
				passwordData.put("password", pwdModel);
				data = passwordService.savePassword(passwordData);
				
				if (data.get("responseCode").equals("200")) {
					data.put("data", userModel);
					data.put("message", "User saved successfully. A password sent to your given email address");
					data.put("responseCode", "200");
					data.put("status", "successful");
				}else {
					data.put("data", userModel);
					data.put("message", "User saved but password data is not saved");
					data.put("responseCode", data.get("responseCode"));
					data.put("status", data.get("status"));
				}
			}	
		}
		return data;
	}

	@Override
	public Map<String, Object> updateUser(UsersModel user, String username) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = userDao.getUserByUsername(username);
		
		if (list.size()>0) {
			user.setId(list.get(0).getId());
			userDao.save(user);
			
			data.put("data", user);
			data.put("message", "User updated");
			data.put("responseCode", "200");
			data.put("status", "successful");
		}else {
			data.put("message", "Failed to update user. No such user found");
			data.put("responseCode", "404");
			data.put("status", "failure");
		}
			
		return data;
	}

	@Override
	public Map<String, Object> getUserBySearchText(String searchText) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = userDao.getUserBySearchText(searchText);
		
		if (list.size()>0) {

			data.put("data", list);
			data.put("message", "User searched complete");
			data.put("responseCode", "200");
			data.put("status", "successful");
		}else {
			data.put("message", "Search word does not match to any of the user");
			data.put("responseCode", "404");
			data.put("status", "failure");
		}
			
		return data;
	}
	
	@Override
	public Map<String, Object> findAll(Pageable pageable){
		Map<String, Object> data = new HashMap<String, Object>();
		Page<UsersModel> userList = null;
		if (pageable!=null) {
			userList = userDao.findAll(pageable); 
		}
		
		if (userList!=null && userList.getSize()>0) {
			data.put("data", userList);
			data.put("message", "Getting user successful");
			data.put("responseCode", "200");
			data.put("status", "successful");
		}else {
			data.put("message", "Failed to fetch user, no user found");
			data.put("responseCode", "404");
			data.put("status", "failure");
		}
		
		return data;
	}

}
