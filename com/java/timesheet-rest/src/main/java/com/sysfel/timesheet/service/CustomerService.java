package com.sysfel.timesheet.service;

import com.sysfel.timesheet.model.Customer;

public interface CustomerService {
	Customer save(Customer customer);
	Customer findByName(String name);
	Customer findById(Long id);
}
