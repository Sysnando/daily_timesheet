package com.sysfel.timesheet.enums;

public enum JobRole {
	
	DRIVER("Driver"),
	LABOURER("Labourer");
	
	String name;
	
	JobRole(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name.toString();
	}
}
