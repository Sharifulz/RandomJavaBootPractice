package com.ctrends.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctrends.dao.IPasswordDao;
import com.ctrends.dao.IUserDao;
import com.ctrends.model.PasswordModel;
import com.ctrends.model.UserAttachmentsModel;
import com.ctrends.model.UsersModel;
import com.ctrends.service.IPasswordService;
import com.ctrends.service.IUserAttachmentService;
import com.ctrends.service.IUserService;
import com.ctrends.util.ICommonApiService;

@RestController
public class UserController {
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IPasswordService passwordService;
	
	@Autowired
	ICommonApiService commonApiService;
	// with pagination - show on app
	// without pagination - bulk use
	/*	
	------- Pagination Test
	@GetMapping("/userpage")
	public Page<UsersModel> getUserOnePage(Pageable pageable){
		return userService.findAll(pageable);
	}
	*/
	
	// http://localhost:9001/users?page=1&size=2
	// http://localhost:9001/users?page=2&size=10&sort=personName
	@GetMapping("/users")
	public ResponseEntity<Map<String, Object>> getUsers(HttpServletRequest request,Pageable pageable, @RequestParam("api_key") String api_key,
			@RequestHeader("latLng") String latLng){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "users";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userService.findAll(pageable);
			if (data.get("responseCode").equals("404")) {
				descMsg = "Users was failed to retrieve by CTrendsKYC API "+request.getServletPath()+ " because of no user found";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
			}else {
				descMsg = "Users was successfully retrieved by CTrendsKYC API "+request.getServletPath();
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
			}
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));

			descMsg = "Users failed to retrieved by CTrendsKYC API "+request.getServletPath()+ " because no such API key found";
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
	
	@GetMapping("/search_user")
	public ResponseEntity<Map<String, Object>> getUserBySearchText(HttpServletRequest request, 
			@RequestParam("api_key") String api_key, @RequestHeader("latLng") String latLng, @RequestHeader("searchText") String searchText){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "search_user";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userService.getUserBySearchText(searchText.toLowerCase());
			
			if (data.get("responseCode").equals("404")) {
				descMsg = "User was failed to retrieve by CTrendsKYC API "+request.getServletPath()+ " because of no data found.";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
			}else {
				descMsg = "User was successfully retrieved by CTrendsKYC API "+request.getServletPath();
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
			}
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));
			descMsg = "User was failed to search by CTrendsKYC API "+request.getServletPath()+ " because no data found";
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
	
	@PostMapping(path="/user/add", consumes= "application/json", produces= "application/json")
	public ResponseEntity<Map<String, Object>>  addUser(HttpServletRequest request, @RequestBody UsersModel users,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {

		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user/add";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userService.saveUser(users);
			
			if (data.get("responseCode").equals("412")) {
				descMsg = "A user was failed to post by CTrendsKYC API "+request.getServletPath()+ " because of validation error.";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.PRECONDITION_FAILED);
			}else {
				descMsg = "A user was successfully posted by CTrendsKYC API "+request.getServletPath();
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
			}
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));

			descMsg = "A user was failed to post by CTrendsKYC API "+request.getServletPath()+ " because no such API key found";
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
	
	@PutMapping(path="/user/update/{username}", consumes= "application/json", produces= "application/json")
	public ResponseEntity<Map<String, Object>> updateUser(HttpServletRequest request, @RequestBody UsersModel user, @PathVariable("username") String username,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user/update/{username}";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			data = userService.updateUser(user, username);
			if (data.get("responseCode").equals("404")) {
				descMsg = "A user was failed to update by CTrendsKYC API "+request.getServletPath()+ " because no such user found";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
			}else {
				descMsg = "A user was successfully updated by CTrendsKYC API "+request.getServletPath();
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
			}
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));
			descMsg = "A user was failed to update by CTrendsKYC API "+request.getServletPath()+ " because no data found";
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
	
	@PutMapping(path="/user/enable/{username}", consumes= "application/json", produces= "application/json")
	Map<String, Object> enableUser(HttpServletRequest request, @PathVariable("username") String username,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user/enable/{username}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			List<UsersModel> list = userDao.getUserByUsername(username);
			if (list.size()>0 && list.get(0)!=null) {
				UsersModel user = list.get(0);
				user.setEnabled(true);
				UsersModel updatedUser = userDao.save(user);
				data.put("data", updatedUser);
			}
			descMsg = "A user was enabled by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to enabled by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		 
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	
	@PutMapping(path="/user/disable/{username}", consumes= "application/json", produces= "application/json")
	Map<String, Object> disableUser(HttpServletRequest request, @PathVariable("username") String username,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user/disable/{username}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			List<UsersModel> list = userDao.getUserByUsername(username);
			if (list.size()>0 && list.get(0)!=null) {
				UsersModel user = list.get(0);
				user.setEnabled(false);
				UsersModel updatedUser = userDao.save(user);
				data.put("data", updatedUser);
			}
			descMsg = "A user was disable by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to disable by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		 
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	
	//------ http://localhost:9001/user_authentication/{username}?api_key=xxxxxxxxx   [POST]
	@PostMapping(path="/user_authentication/{username}", consumes= "application/json", produces= "application/json")
	public ResponseEntity<Map<String, Object>> setUserAuthentication(HttpServletRequest request,@PathVariable("username") String username,
			@RequestBody PasswordModel password, @RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user_authentication/{username}";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		 
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			List<UsersModel> usr = userDao.getUserByUsername(username);
			if (usr.size()>0) { 
				Map<String, Object> passwordData = new HashMap<String, Object>();
				passwordData.put("user", usr.get(0));
				passwordData.put("password", password);
				data = passwordService.authenticateUser(passwordData);	
				
				if (data.get("responseCode").equals("401")) {
					System.out.println("----------------- inside unauthorised");
					descMsg = "A user failed to authenticate/login by CTrendsKYC API "+request.getServletPath()+ " because password does not matched. ";
					responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.UNAUTHORIZED);
				}else if(data.get("responseCode").equals("402")){
					descMsg = "A user failed to authenticate/login by CTrendsKYC API "+request.getServletPath()+ " because password is too short";
					responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.PRECONDITION_FAILED);
				}else if(data.get("responseCode").equals("404")){
					descMsg = "A user failed to authenticate/login by CTrendsKYC API "+request.getServletPath()+ " because password does not set yet";
					responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
				}else {
					descMsg = "A user successful to authenticate/login by CTrendsKYC API "+request.getServletPath()+ " password matched";
					responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
				}
				
			}else {
				descMsg = "A user failed to authenticate/login by CTrendsKYC API "+request.getServletPath()+ "because no such user found";
				data.put("message", "Username invalid or not available");
				data.put("responseCode", "404");
				data.put("status", "failure");
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
			}
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));
			descMsg = "A user was failed to authenticate/login by CTrendsKYC API "+request.getServletPath()+ " because no such API data found";
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

	//---------- update or insert password
	@PostMapping(path="/password/update/{username}", consumes= "application/json", produces= "application/json")
	public ResponseEntity<Map<String, Object>> updatePassword(HttpServletRequest request, @PathVariable("username") String username,
			@RequestHeader("latLng") String latLng, @RequestBody PasswordModel password, @RequestParam("api_key") String api_key) {
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "password/update/{username}";
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			List<UsersModel> user = userDao.getUserByUsername(username);
			if (user.size()>0) {
				Map<String, Object> passwordData = new HashMap<String, Object>();
				passwordData.put("user", user.get(0));
				passwordData.put("password", password);
				data = passwordService.savePassword(passwordData);
				
				if (data.get("responseCode").equals("412")) {
					descMsg = "A user password was failed to update by CTrendsKYC API "+request.getServletPath()+ " because of validation error";
					responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.PRECONDITION_FAILED);
				}else {
					descMsg = "A user password was updated by CTrendsKYC API "+request.getServletPath()+ " successfully";
					responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
				}
				
			}else {
				data.put("message", "No such user found. Try again!");
				data.put("responseCode", "404");
				data.put("status", "failure");
				descMsg = "A user password was failed to update by CTrendsKYC API "+request.getServletPath()+ " because no user data found";
				responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
			}
		}else {
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));
			descMsg = "A user password was failed to update by CTrendsKYC API "+request.getServletPath()+ " because no data found";
			responseEntity = new ResponseEntity<Map<String,Object>>(data, HttpStatus.NOT_FOUND);
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
	
	//------- -------http://localhost:9001/password/reset/{username}?api_key=xxxxxxxxx   [POST]

	@PostMapping(path="/password/reset/{username}", consumes= "application/json", produces= "application/json")
	Map<String, Object> resetPassword(HttpServletRequest request, @PathVariable("username") String username,
			@RequestHeader("latLng") String latLng, @RequestBody PasswordModel password, @RequestParam("api_key") String api_key) {
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "password/reset/{username}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			List<UsersModel> user = userDao.getUserByUsername(username);
			if (user.size()>0) {
				data = passwordService.resetPassword(user.get(0).getEmail(), user);	
			}
			descMsg = "A user password reset code sent by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "N/A");
			data.put("message", map.get("message"));
			data.put("responseCode", map.get("responseCode"));
			data.put("status", map.get("status"));
			descMsg = "A user password was failed to update by CTrendsKYC API "+request.getServletPath()+ " because no data found";
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
	
	@GetMapping("/user_by_id/{id}")
	public Map<String, Object> getUserById(HttpServletRequest request, @PathVariable("id") UUID id, 
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user_by_id/{id}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUserById(id);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	
	
	@GetMapping("/user_by_username/{username}")
	public Map<String, Object> getUserByUsername(HttpServletRequest request, @PathVariable("username") String username, 
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "user_by_username/{username}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUserByUsername(username);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());

		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	
	//---------------------- API for using GEOLOCATION CRITERIA ----------------------------
	
	// Union Code -------------- BD55523953 (------Kakina -------)
	@GetMapping("/users_by_union_code/{code}")
	public Map<String, Object> getUsersByUnionCode(HttpServletRequest request, @PathVariable("code") String code, 
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "users_by_union_code/{code}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUsersByUnionCode(code);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	// Union Id ---------------- f1d48748-6e2b-47a6-9411-404ec38c26b8
	@GetMapping("/users_by_union_id/{id}")
	public Map<String, Object> getUsersByUnionId(HttpServletRequest request, @PathVariable("id") UUID id,
				@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "users_by_union_id/{id}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUsersByUnionId(id);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
		
	}
	
	// Subdistrict Code -------------- BD555239
	@GetMapping("/users_by_subdistrict_code/{code}")
	public Map<String, Object> getUsersBySubdistrictCode(HttpServletRequest request, @PathVariable("code") String code, 
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "users_by_subdistrict_code/{code}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUsersBySubdistrictCode(code);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
		
	}
	// Subdistrict Id -------------- 46fead81-97c8-4692-9647-235e8e0284b4
	@GetMapping("/users_by_subdistrict_id/{id}")
	public Map<String, Object> getUsersBySubdistrictId(HttpServletRequest request, @PathVariable("id") UUID id,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
	Timestamp startTime = new Timestamp(System.currentTimeMillis());
	final String endpoint = "users_by_subdistrict_id/{id}";
	
	Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

	Map<String, Object> data = new HashMap<String, Object>();
	List<UsersModel> list = null;
	String descMsg = "";
	
	if (map.get("status").toString().equalsIgnoreCase("successful")) {
		list =  userDao.getUsersBySubdistrictId(id);
		data.put("data", list);
		descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
	}else {
		data.put("data", "No Data Found");
		descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
	}
	
	Timestamp endTime = new Timestamp(System.currentTimeMillis());
	
	map.put("startTime", startTime);
	map.put("endTime", endTime); 
	map.put("apiEndpoint", endpoint);
	map.put("latLng", latLng);
	map.put("descMsg", descMsg);
	
	data.put("status", map.get("status"));
	data.put("responseCode", map.get("responseCode"));
	data.put("message", map.get("message"));
	
	commonApiService.postToLogServer(request,map);
	
	return data;
	}
	
	// District Code -------------- BD5552
	@GetMapping("/users_by_district_code/{code}")
	public Map<String, Object> getUsersByDistrictCode(HttpServletRequest request, @PathVariable("code") String code, 
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "users_by_district_code/{code}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUsersByDistrictCode(code);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
		
	}
	//District Id ----------- 940ed986-581d-4e10-a7d0-0695b9777164
	@GetMapping("/users_by_district_id/{id}")
	public Map<String, Object> getUsersByDistrictId(HttpServletRequest request, @PathVariable("id") UUID id,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
	Timestamp startTime = new Timestamp(System.currentTimeMillis());
	final String endpoint = "users_by_district_id/{id}";
	
	Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

	Map<String, Object> data = new HashMap<String, Object>();
	List<UsersModel> list = null;
	String descMsg = "";
	
	if (map.get("status").toString().equalsIgnoreCase("successful")) {
		list =  userDao.getUsersByDistrictId(id);
		data.put("data", list);
		descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
	}else {
		data.put("data", "No Data Found");
		descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
	}
	
	Timestamp endTime = new Timestamp(System.currentTimeMillis());
	
	map.put("startTime", startTime);
	map.put("endTime", endTime); 
	map.put("apiEndpoint", endpoint);
	map.put("latLng", latLng);
	map.put("descMsg", descMsg);
	
	data.put("status", map.get("status"));
	data.put("responseCode", map.get("responseCode"));
	data.put("message", map.get("message"));
	
	commonApiService.postToLogServer(request,map);
	
	return data;
	}
	
	// Division Code -------------- BD55
	@GetMapping("/users_by_div_code/{code}")
	public Map<String, Object> getUsersByDivisionCode(HttpServletRequest request, @PathVariable("code") String code, 
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		final String endpoint = "users_by_div_code/{code}";
		
		Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

		Map<String, Object> data = new HashMap<String, Object>();
		List<UsersModel> list = null;
		String descMsg = "";
		
		if (map.get("status").toString().equalsIgnoreCase("successful")) {
			list =  userDao.getUsersByDivisionCode(code);
			data.put("data", list);
			descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
		}else {
			data.put("data", "No Data Found");
			descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
		}
		
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		
		map.put("startTime", startTime);
		map.put("endTime", endTime); 
		map.put("apiEndpoint", endpoint);
		map.put("latLng", latLng);
		map.put("descMsg", descMsg);
		
		data.put("status", map.get("status"));
		data.put("responseCode", map.get("responseCode"));
		data.put("message", map.get("message"));
		
		commonApiService.postToLogServer(request,map);
		
		return data;
	}
	// Division Id -------------- cc8c22e3-8fee-448d-b5a5-52b611ce1fdf
	@GetMapping("/users_by_div_id/{id}")
	public Map<String, Object> getUsersByDivisionId(HttpServletRequest request, @PathVariable("id") UUID id,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key){
		
	Timestamp startTime = new Timestamp(System.currentTimeMillis());
	final String endpoint = "users_by_div_id/{id}";
	
	Map<String, Object> map = commonApiService.validateApiKey(api_key, endpoint);

	Map<String, Object> data = new HashMap<String, Object>();
	List<UsersModel> list = null;
	String descMsg = "";
	
	if (map.get("status").toString().equalsIgnoreCase("successful")) {
		list =  userDao.getUsersByDivisionId(id);
		data.put("data", list);
		descMsg = "A user was retrieved by CTrendsKYC API "+request.getServletPath()+ " successfully";
	}else {
		data.put("data", "No Data Found");
		descMsg = "A user was failed to retrived by CTrendsKYC API "+request.getServletPath()+ " because no data found";
	}
	
	Timestamp endTime = new Timestamp(System.currentTimeMillis());
	
	map.put("startTime", startTime);
	map.put("endTime", endTime); 
	map.put("apiEndpoint", endpoint);
	map.put("latLng", latLng);
	map.put("descMsg", descMsg);
	
	data.put("status", map.get("status"));
	data.put("responseCode", map.get("responseCode"));
	data.put("message", map.get("message"));
	
	commonApiService.postToLogServer(request,map);
	
	return data;
	}
}













