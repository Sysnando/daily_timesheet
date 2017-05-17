package com.sysfel.timesheet.service;

import java.util.Collection;

import com.sysfel.timesheet.model.Job;

public interface JobService {
	Job save(Job job);
	Collection<Job> findAll();
	Job findJobById(Long id);
}
