package com.exam.service;

import java.util.Map;


public interface IProcessEmail {
	public Map<String, Object> sendEmailTo(String to);
}
