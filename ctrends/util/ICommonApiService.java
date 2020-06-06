package com.ctrends.util;

import java.util.Map;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;


public interface ICommonApiService {
	
	public Map<String, Object> validateApiKey(String api_key, String endPoint);
	public Map<String, Object> postToLogServer(HttpServletRequest req, Map<String, Object> map);
	
}
