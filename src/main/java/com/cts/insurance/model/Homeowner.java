package com.cts.insurance.model;

import java.sql.Date;

public class Homeowner {

	private int userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private int retiredStatus;
	private String ssn;
	private String email;
	
	//constructor 	
	public Homeowner() {

	}
	public Homeowner(int userId, String firstName, String lastName, Date dob, int retiredStatus2, String ssn,
			String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.retiredStatus = retiredStatus2;
		this.ssn = ssn;
		this.email = email;
	}
	

	//getter & setter
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getRetiredStatus() {
		return retiredStatus;
	}
	public void setRetiredStatus(int retiredStatus) {
		this.retiredStatus = retiredStatus;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
