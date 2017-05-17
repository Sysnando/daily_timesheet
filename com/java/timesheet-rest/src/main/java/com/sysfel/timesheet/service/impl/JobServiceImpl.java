package com.sysfel.timesheet.service.impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysfel.timesheet.model.Job;
import com.sysfel.timesheet.repository.JobRepository;
import com.sysfel.timesheet.service.JobService;

@Transactional
//@ControllerAdvice
@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public Job save(Job job) {
		return jobRepository.save(job);
	}
	
	public Collection<Job> findAll(){
		return jobRepository.findAll();
	}
	
	public Job findJobById(Long id){
		return jobRepository.findJobById(id);
	}
}
