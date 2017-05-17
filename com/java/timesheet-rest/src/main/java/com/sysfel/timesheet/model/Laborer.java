package com.sysfel.timesheet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sysfel.timesheet.enums.JobRole;

@Entity
public class Laborer {
	
//	public Laborer(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	private String initial;
	private JobRole jobRole;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitial() {
		if(this.initial != null && this.name != null){
			return this.name.substring(0, 1);
		}
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public JobRole getJobRole() {
		return jobRole;
	}

	public void setJobRole(JobRole jobRole) {
		this.jobRole = jobRole;
	}
}
