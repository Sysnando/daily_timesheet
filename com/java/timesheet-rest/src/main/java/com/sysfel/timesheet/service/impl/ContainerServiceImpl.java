package com.sysfel.timesheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysfel.timesheet.model.Container;
import com.sysfel.timesheet.repository.ContainerRepository;
import com.sysfel.timesheet.service.ContainerService;

@Service
public class ContainerServiceImpl implements ContainerService{

	@Autowired
	private ContainerRepository containerRepository;
	
	@Override
	public List<Container> findAll() {
		return containerRepository.findAll();
	}

}
