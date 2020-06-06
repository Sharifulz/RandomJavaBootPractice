package com.ctrends.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctrends.model.UserAttachmentsModel;
import com.ctrends.service.IUserAttachmentService;
import com.ctrends.util.ICommonApiService;

@RestController
public class UserAttachmentController {
	
	@Autowired
	IUserAttachmentService userAttachmentService;
	
	@Autowired
	ICommonApiService commonApiService;
	
	@PostMapping(path="/user_attachment/add", consumes= "application/json", produces= "application/json")
	public ResponseEntity<Map<String, Object>> addUserAttachment(HttpServletRequest request, @RequestBody List<UserAttachmentsModel> userAttachments,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user_attachment/add";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userAttachmentService.saveAttachments(userAttachments);
			if (data.get("responseCode").equals("412")) {
				descMsg = "A user attachment was failed to post by CTrendsKYC API "+request.getServletPath()+ " because of validation error";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.PRECONDITION_FAILED);
			}else {
				descMsg = "A user attachment was posted by CTrendsKYC API "+request.getServletPath()+ " successfully";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
			}
			
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));

			descMsg = "A user attachment was failed to post by CTrendsKYC API "+request.getServletPath()+ " because no such API data found";
			responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.UNAUTHORIZED);	
		}
		 
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);

		commonApiService.postToLogServer(request,map);
		
		return responseEntity;
	}
	
	
	@PutMapping(path="/user_attachment/update/{username}", consumes= "application/json", produces= "application/json")
	Map<String, Object> updateUserAttachment(HttpServletRequest request, @RequestBody UserAttachmentsModel userAttachments,
			@PathVariable("username") String username, @RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user_attachment/update/{username}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userAttachmentService.updateUserAttachments(username, userAttachments);
			descMsg = "A user attachment was updated by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "N/A");
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));

			descMsg = "A user attachment was failed to updated by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		 
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);

		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	
	@DeleteMapping(path="/user_attachment/delete/{username}", consumes= "application/json", produces= "application/json")
	Map<String, Object> deleteUserAttachment(HttpServletRequest request, @RequestBody UserAttachmentsModel userAttachments,
			@PathVariable("username") String username, @RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user_attachment/delete/{username}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userAttachmentService.deleteUserAttachments(username, userAttachments);
			descMsg = "A user attachment was deleted by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "N/A");
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));

			descMsg = "A user attachment was failed to delete by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		 
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);

		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	
	
	
}
