package com.cts.insurance.model;

public class Quote {
	
	private int quoteId;
	private int locationId;
	private Float monthlyPremium;
	private Float dwellingCoverage;
	private Float detatchedStructures;
	private Float personalProperty;
	private Float addLivingExp;
	private Float medicalExpenses;
	private Float deductible;
	
	//constructor 	
	public Quote() {

	}
	
	public Quote(int quoteId, int locationId, Float monthlyPremium, Float dwellingCoverage, Float detatchedStructures,
			Float personalProperty, Float addLivingExp, Float medicalExpenses, Float deductible) {
		this.quoteId = quoteId;
		this.locationId = locationId;
		this.monthlyPremium = monthlyPremium;
		this.dwellingCoverage = dwellingCoverage;
		this.detatchedStructures = detatchedStructures;
		this.personalProperty = personalProperty;
		this.addLivingExp = addLivingExp;
		this.medicalExpenses = medicalExpenses;
		this.deductible = deductible;
	}
	

	//getter & setter
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public Float getMonthlyPremium() {
		return monthlyPremium;
	}
	public void setMonthlyPremium(Float monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}
	public Float getDwellingCoverage() {
		return dwellingCoverage;
	}
	public void setDwellingCoverage(Float dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}
	public Float getDetatchedStructures() {
		return detatchedStructures;
	}
	public void setDetatchedStructures(Float detatchedStructures) {
		this.detatchedStructures = detatchedStructures;
	}
	public Float getPersonalProperty() {
		return personalProperty;
	}
	public void setPersonalProperty(Float personalProperty) {
		this.personalProperty = personalProperty;
	}
	public Float getAddLivingExp() {
		return addLivingExp;
	}
	public void setAddLivingExp(Float addLivingExp) {
		this.addLivingExp = addLivingExp;
	}
	public Float getMedicalExpenses() {
		return medicalExpenses;
	}
	public void setMedicalExpenses(Float medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}
	public Float getDeductible() {
		return deductible;
	}
	public void setDeductible(Float deductible) {
		this.deductible = deductible;
	}
	
	

}
