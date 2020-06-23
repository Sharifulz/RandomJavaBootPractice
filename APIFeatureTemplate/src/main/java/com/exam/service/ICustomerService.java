package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.model.CustomerModel;


public interface ICustomerService {
	public List<CustomerModel> getAllCustomer();
	public CustomerModel saveCustomer(CustomerModel customer);
}
