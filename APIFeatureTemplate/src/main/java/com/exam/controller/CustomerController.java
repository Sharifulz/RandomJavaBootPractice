package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.CustomerModel;
import com.exam.service.CustomerService;
import com.exam.service.ICustomerService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	//-----------http://localhost:9099/getCustomers
	
	@GetMapping("/getCustomers")
	public List<CustomerModel> getAllCustomer() {
		List<CustomerModel> customerList= null;
		try {
			customerList = customerService.getAllCustomer();
			if (customerList!=null && customerList.size()>0) {
				return customerList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	@PostMapping("/addCustomers")
	public List<CustomerModel> saveCustomer(@RequestBody List<CustomerModel> customers) {
		List<CustomerModel> customerList= new ArrayList<CustomerModel>();
		
		for (CustomerModel customerModel : customers) {
				customerList.add(customerService.saveCustomer(customerModel));
		}
		return customerList;
		
	}
	
	
}
