package com.sysfel.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysfel.timesheet.model.Laborer;
import com.sysfel.timesheet.service.LaborerService;

@RestController
public class LaborerController {

	@Autowired
	LaborerService laborerService;
	
	@RequestMapping(value="/laborer/add")
	Laborer  add(Laborer laborer){
		return laborerService.save(laborer);
	}
	
//	public void validateCustomer(String customerName){
//		Customer customer = this.laborerService.findByName(customerName);
//		if(customer == null){
//			throw new CustomerNotFoundException(customerName);
//		}
//	}
}
