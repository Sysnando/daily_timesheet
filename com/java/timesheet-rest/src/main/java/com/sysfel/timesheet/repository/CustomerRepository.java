package com.sysfel.timesheet.repository;

import org.springframework.data.repository.Repository;

import com.sysfel.timesheet.model.Customer;

public interface CustomerRepository extends Repository<Customer, Long>{
	Customer save(Customer customer);
	Customer findByName(String name);
	Customer findById(Long id);
}
