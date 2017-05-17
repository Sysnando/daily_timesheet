package com.sysfel.timesheet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Container {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String reference;
	
	@Column
	private Integer size;
	
	@Column
	private Date startTime;
	
	@Column
	private Date finishTime;
	
	@Column
	private boolean isForkliftTime;
	
	@Column
	private boolean isWaitingTime;
//	private Integer shrinWrap;
	
	@Column
	private boolean isExcessiveWeight;
	
	public Container(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public boolean isForkliftTime() {
		return isForkliftTime;
	}
	public void setForkliftTime(boolean isForkliftTime) {
		this.isForkliftTime = isForkliftTime;
	}
	public boolean isWaitingTime() {
		return isWaitingTime;
	}
	public void setWaitingTime(boolean isWaitingTime) {
		this.isWaitingTime = isWaitingTime;
	}
	public boolean isExcessiveWeight() {
		return isExcessiveWeight;
	}
	public void setExcessiveWeight(boolean isExcessiveWeight) {
		this.isExcessiveWeight = isExcessiveWeight;
	}
}
