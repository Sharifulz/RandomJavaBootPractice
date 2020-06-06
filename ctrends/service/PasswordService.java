package com.ctrends.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.dao.IPasswordDao;
import com.ctrends.model.PasswordModel;
import com.ctrends.model.UsersModel;
import com.ctrends.util.EmailService;
import com.ctrends.util.IEncoderDecoder;

@Service
public class PasswordService implements IPasswordService {

	private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{10,20})";
	
	@Autowired
	IPasswordDao passwordDao;
	
	@Autowired
	IEncoderDecoder encoderDecoder;
	
	@Autowired
	EmailService emailService;
	
	@Override
	public Map<String, Object> savePassword(Map<String, Object> passwordData) {
		UsersModel user = (UsersModel) passwordData.get("user");
		PasswordModel passwordModel = (PasswordModel) passwordData.get("password");
		Map<String, Object> data = new HashMap<String, Object>();
		String decodeFrontendPass = null;
		// validation rule :
		//1. min length 10, 2. no space,
		//3. No special character cause base64 can not accept special character. 
		//4. alpha numeric
		//String givenPassword = passwordModel.getPwd();
		decodeFrontendPass = encoderDecoder.decodeString(passwordModel.getPwd(),"");
		Pattern pat = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(decodeFrontendPass);
		boolean isSpecialCharacterExists = mat.find();
		
		if (decodeFrontendPass.length()<10) {
			System.out.println("---------------------- "+ decodeFrontendPass);
			data.put("message", "Password is too short, must be minimum 10 character");
			data.put("responseCode", "412");
			data.put("status", "failure");
		}else if (decodeFrontendPass.contains(" ") || isSpecialCharacterExists) {
			data.put("message", "Password can not have any whitespace or any special character");
			data.put("responseCode", "412");
			data.put("status", "failure");
		}else{
			Pattern pattern = Pattern.compile(PASSWORD_REGEX);
			Matcher matcher = pattern.matcher(decodeFrontendPass);
			if (matcher.matches()) {
				//------- decrypt password that is getting from front end using different algorithm from back end(here we use Base64 for back end)
				
				String encriptedPassword = encoderDecoder.encodeString(decodeFrontendPass, "cts");
				int foundSize = passwordDao.getPasswordByUsername(user.getUsername()).size();
				
				if(foundSize>0) { 
					int updateRow = passwordDao.updatePassword(encriptedPassword, user.getUsername());
					//data.put("data", user);
					if (updateRow>0) {
						data.put("message", "Password Updated");
						data.put("responseCode", "200");
						data.put("status", "successful");
					}
				}else{
					passwordModel.setUsername(user.getUsername());
					passwordModel.setPersonName(user.getPersonName());
					passwordModel.setPwd(encriptedPassword);
					passwordDao.save(passwordModel);
					
					//data.put("data", user);
					data.put("message", "Password Saved");
					data.put("responseCode", "200");
					data.put("status", "successful");
				} 
			}else {
				data.put("message", "Password must be AlphaNumerical and must have capital letter");
				data.put("responseCode", "412");
				data.put("status", "failure");
			}
		}
			
		return data;
	}

	@Override
	public Map<String, Object> authenticateUser(Map<String, Object> passwordData) {
		UsersModel user = (UsersModel) passwordData.get("user");
		PasswordModel passwordModel = (PasswordModel) passwordData.get("password");
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (passwordModel.getPwd()==null || passwordModel.getPwd().equals("")) {
			data.put("message", "Password field is missing or empty. Please check again");
			data.put("responseCode", "402");
			data.put("status", "failure");
			return data;
		}else if (passwordModel.getPwd().length()<10) {
			data.put("message", "Password is invalid or too short. Please check again");
			data.put("responseCode", "402");
			data.put("status", "failure");
			return data;
		}
		
		List<PasswordModel> password = passwordDao.getPasswordByUsername(user.getUsername());

		if (password.size()>0) { 
			// ------password found, now decrypt both and match
			//------- decrypt password that is getting from front end using different algorithm from back end(here we use Base64 for back end)
			String decodeFrontendPass = encoderDecoder.decodeString(passwordModel.getPwd(),"");
			String decodeMatchingdPass = encoderDecoder.decodeString(password.get(0).getPwd(), "cts");
			if (decodeFrontendPass.equals(decodeMatchingdPass)) {
				data.put("data", user);
				data.put("message", "Password matched");
				data.put("responseCode", "200");
				data.put("status", "successful");
				return data;
			}else {
				data.put("message", "Password does not matched");
				data.put("responseCode", "401");
				data.put("status", "failure");
				return data;
			}
		}else {
			data.put("message", "User have not set password yet");
			data.put("responseCode", "404");
			data.put("status", "failure");
			return data;
		}
	}
	
	@Override
	public Map<String, Object> resetPassword(String to, List<UsersModel> user) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		Map<String, Object> passwordData = new HashMap<String, Object>();
		
		String resetCode = "123456789"+"121212";
		String subject = "Password Reset Code";
		String body = "Your request for password reset is approved, please use <span style='color:red'>"
						+resetCode+"</span> as your password reset code";
		
		PasswordModel passModel = new PasswordModel();
		passModel.setPwd(String.valueOf(resetCode));
		passwordData.put("user", user.get(0));
		passwordData.put("password", passModel);
		
		this.savePassword(passwordData);

		try {
			emailService.sendMail(to, subject, body);
			String message = "A password reset code was sent on your mail address";
			data.put("data", to);
			data.put("message", message);
			data.put("responseCode", "200");
			data.put("status", "successful");
		} catch (MessagingException e) {
			data.put("data", to);
			data.put("message", e.getLocalizedMessage());
			data.put("responseCode", "400");
			data.put("status", "failure");
			e.printStackTrace();
		}
		
		return data;
		
	}

	@Override
	public Map<String, Object> sendPAsswordToMail(String to, String subject, String body) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			emailService.sendMail(to, subject, body);
			String message = "A password reset code was sent on your mail address";
			data.put("data", to);
			data.put("message", message);
			data.put("responseCode", "200");
			data.put("status", "successful");
		} catch (MessagingException e) {
			data.put("data", to);
			data.put("message", e.getLocalizedMessage());
			data.put("responseCode", "404");
			data.put("status", "failure");
			e.printStackTrace();
		}
		
		return data;
	}

	

}
