package com.sysfel.timesheet.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysfel.timesheet.model.Customer;
import com.sysfel.timesheet.repository.CustomerRepository;
import com.sysfel.timesheet.service.CustomerService;

@Transactional
//@ControllerAdvice
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}
	
	public Customer findById(Long id){
		return customerRepository.findById(id);
	}
}
