package com.cts.insurance.model;

import java.sql.Date;

public class Policy {

	private int policyId;
	private int quoteId;
	private int userId;
	private Date effectiveDate;
	private Date endDate;
	private int term;
	private String policyStatus;
	
	//constructor 	
	public Policy() {

	}
	
	public Policy(int policyId, int quoteId, int userId, Date effectiveDate, Date endDate, int term,
			String policyStatus) {
		this.policyId = policyId;
		this.quoteId = quoteId;
		this.userId = userId;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.term = term;
		this.policyStatus = policyStatus;
	}
	
	public Policy(int policyId, Date effectiveDate, Date endDate, String policyStatus) {
		this.policyId = policyId;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.policyStatus = policyStatus;
	}



	//getter & setter
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public void setEffectiveDate(java.util.Date currentDate) {
		// TODO Auto-generated method stub
		
	}

	public void setEndDate(java.util.Date nextYear) {
		// TODO Auto-generated method stub
		
	}
	
	

}
