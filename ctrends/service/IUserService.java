package com.ctrends.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ctrends.model.UsersModel;

public interface IUserService {
	public UsersModel getUserByUsername(String username);
	public Map<String, Object> saveUser(UsersModel user);
	public Map<String, Object> updateUser(UsersModel user,String username);
	public Map<String, Object> getUserBySearchText(String searchText);
	public Map<String, Object> findAll(Pageable pageable);
}
