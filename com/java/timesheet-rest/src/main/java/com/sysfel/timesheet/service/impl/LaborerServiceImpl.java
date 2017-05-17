package com.sysfel.timesheet.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysfel.timesheet.model.Laborer;
import com.sysfel.timesheet.repository.LaborerRepository;
import com.sysfel.timesheet.service.LaborerService;

@Transactional
//@ControllerAdvice
@Service
public class LaborerServiceImpl implements LaborerService{

	@Autowired
	private LaborerRepository laborerRepository;
	
	@Override
	public Laborer save(Laborer laborer) {
		return laborerRepository.save(laborer);
	}

	@Override
	public Laborer findByName(String name) {
		return laborerRepository.findByName(name);
	}
	
	public Laborer findById(Long id){
		return laborerRepository.findById(id);
	}
}
