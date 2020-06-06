package com.ctrends.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ctrends.dao.IApiKeyDao;
import com.ctrends.log.model.ApiAccessLogModel;
import com.ctrends.model.ApiKeyEndpointsModel;

@Service
public class CommonApiService implements ICommonApiService{
	
	@Autowired
	IApiKeyDao apiKeyDao;
	
	@Autowired
	GeoCoordinate geoCoordinate;

	@Autowired
	EmailService emailService;
	
	@Autowired
	IEncoderDecoder encoderDecoder;
	
	@Value("${access_log_endpoint.url}")
	private String accessLogEndpoint;
	
	@Override
	public Map<String, Object> validateApiKey(String api_key, String endPoint) {
		
		Map<String, Object> map = new HashMap<String, Object>();
 
		//Encoded String : Y3RzQkRBMTIzNDU2Nzg5
		//Decoded String : BDA123456789
		
		String decodedApiKey = null;
		
		try {
			decodedApiKey = encoderDecoder.decodeString(api_key, "cts");
		} catch (IllegalArgumentException e) {
			map.put("status", "Failure");
			map.put("responseCode", "401");
			map.put("message", "API Key is too short or Invalid, please check");
			map.put("apiData", new ApiKeyEndpointsModel());
			return map;
		}
		
		List<ApiKeyEndpointsModel> apiData = apiKeyDao.getByApiKey(decodedApiKey, endPoint);
		
		if (apiData.size()>0) {
			Date dt = new Date(System.currentTimeMillis());
			if (apiData.get(0).getExpiryDate().after(dt)) {
				
				map.put("status", "Successful");
				map.put("responseCode", "200");
				map.put("message", "API key is valid");
				map.put("apiData", apiData.get(0));

			}else {
				map.put("status", "Failure");
				map.put("responseCode", "400");
				map.put("message", "API key is expired");
				map.put("apiData", apiData.get(0));
			}
		}else {
			map.put("status", "Failure");
			map.put("responseCode", "401");
			map.put("message", "No such API key found");
			map.put("apiData", new ApiKeyEndpointsModel());
		}
		// ------------------ All goes to api_access_log table
		return map;
	}  
	
	@Override
	public Map<String, Object> postToLogServer(HttpServletRequest req, Map<String, Object> map) {
		
		//final String url = "http://localhost:9005/api_access_log/add?api_key=BDA123456789";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    ResponseEntity<String> result= null;
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
		ApiAccessLogModel accessLog = new ApiAccessLogModel();
		
	    ApiKeyEndpointsModel ebsApiKey = (ApiKeyEndpointsModel) map.get("apiData"); 
	    String apiEndpoint = (String) map.get("apiEndpoint");
	    String latLng = (String) map.get("latLng");
	    String[] latLngArray = latLng.split(",");
	    String description = (String) map.get("descMsg");
	    String attemptOutcome = (String) map.get("status");
	    
	    Timestamp startTime = (Timestamp) map.get("startTime");
	    Timestamp endTime = (Timestamp) map.get("endTime");
	    long duration = endTime.getTime() - startTime.getTime();
	    
	    double distance = geoCoordinate.geoPointDifferenceInKm(ebsApiKey.getRegisteredLatitude(),
	    		Double.parseDouble(latLngArray[0]), ebsApiKey.getRegisteredLongitude(), Double.parseDouble(latLngArray[1]));
	     
	      accessLog.setClientCode(ebsApiKey.getClientCode());
	      accessLog.setClientName(ebsApiKey.getClientName());
	      accessLog.setAppCode("KYC");
	      accessLog.setAppName("KYC");
	      accessLog.setApiEndpoint(apiEndpoint);
	      accessLog.setApiPathWithParams(req.getServletPath());
	      accessLog.setAttemptOutcome(attemptOutcome);
	      accessLog.setApiResponseCode(200);
	      accessLog.setDescription(description);
	      
	      accessLog.setActionDate(new Date(System.currentTimeMillis()));
	      accessLog.setCreatedAt(new Timestamp(System.currentTimeMillis()));
	      accessLog.setStartTime(startTime);
	      accessLog.setEndTime(endTime);
	      accessLog.setDuration(duration);
	      
	      accessLog.setRegisteredIp(ebsApiKey.getRegisteredIp());
	      accessLog.setDeviceIp(req.getRemoteAddr());
	      accessLog.setDeviceLatitude(Double.parseDouble(latLngArray[0]));
	      accessLog.setDeviceLongitude(Double.parseDouble(latLngArray[1]));
	      accessLog.setDistanceFromRegisteredLocKm(distance);
	      
	      //----------- Need to ask sir from where can I get this
	      accessLog.setDeviceName(req.getRemoteUser());
	      accessLog.setRegisteredLatitude(ebsApiKey.getRegisteredLatitude());
	      accessLog.setRegisteredLongitude(ebsApiKey.getRegisteredLongitude());
		
		HttpEntity<ApiAccessLogModel> request = new HttpEntity<>(accessLog, headers);
		 
		try {
			result = restTemplate.postForEntity(accessLogEndpoint, request, String.class);
			
			return map;
			
		} catch (Exception e) {
			
			//emailService.sendMail("shaarifulz@gmail.com", "For Admin", "An Exception Occured");
			map.put("status", "exception");
			e.printStackTrace();
			
			return map;
		}
	} 
} 
 

