package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ICustomerDao;
import com.exam.model.CustomerModel;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public List<CustomerModel> getAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public CustomerModel saveCustomer(CustomerModel customer) {
		return customerDao.save(customer);
	}

}
