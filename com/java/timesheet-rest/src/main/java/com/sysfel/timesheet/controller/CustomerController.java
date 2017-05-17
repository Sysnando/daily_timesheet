package com.sysfel.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysfel.timesheet.exception.CustomerNotFoundException;
import com.sysfel.timesheet.model.Customer;
import com.sysfel.timesheet.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customer/add")
	Customer add(Customer customer){
//		this.validateCustomer(customer.getName());
		return customerService.save(customer);
	}
	
	public void validateCustomer(String customerName){
		Customer customer = this.customerService.findByName(customerName);
		if(customer == null){
			throw new CustomerNotFoundException(customerName);
		}
	}
}
