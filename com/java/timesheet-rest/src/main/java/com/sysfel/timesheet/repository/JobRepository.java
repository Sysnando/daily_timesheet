package com.sysfel.timesheet.repository;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import com.sysfel.timesheet.model.Job;

public interface JobRepository extends Repository<Job, Long>{
	Job save(Job job);
	Collection<Job> findAll();
	Job findJobById(Long id);
}
