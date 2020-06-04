package com.exam.service;

import java.util.Map;

public interface IPasswordService {
	public boolean matchPassword(String password);
	public Map<String, Object> generateRandomPass();
}
