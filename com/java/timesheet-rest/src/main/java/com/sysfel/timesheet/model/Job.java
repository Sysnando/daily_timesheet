package com.sysfel.timesheet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Job {

	public Job() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne(cascade=CascadeType.MERGE)
	private Customer customer;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="job_id")
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Laborer> lsLaborer;

	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="job_id")
	private List<Container> lsContainer;
	
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Laborer> getLsLaborer() {
		return lsLaborer;
	}

	public void setLsLaborer(List<Laborer> lsLaborer) {
		this.lsLaborer = lsLaborer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Container> getLsContainer() {
		return lsContainer;
	}

	public void setLsContainer(List<Container> lsContainer) {
		this.lsContainer = lsContainer;
	}

	@Override
	public String toString() {

		return "Job [id=" + id + ", address=" + address + ", date=" + date + "]";
	}
}
