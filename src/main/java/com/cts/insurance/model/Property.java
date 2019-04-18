package com.cts.insurance.model;

public class Property {

	private int locationId;
	private Float marketValue;
	private int yearBuilt;
	private int squareFootage;
	private String dwellingType;
	private String roofMaterial;
	private String garageType;
	private int fullBaths;
	private int halfBaths;
	private int pool;
	
	//constructor 		
	public Property() {

	}
	
	public Property(int locationId, Float marketValue, int yearBuilt, int squareFootage, String dwellingType,
			String roofMaterial, String garageType, int fullBaths, int halfBaths, int pool) {
		this.locationId = locationId;
		this.marketValue = marketValue;
		this.yearBuilt = yearBuilt;
		this.squareFootage = squareFootage;
		this.dwellingType = dwellingType;
		this.roofMaterial = roofMaterial;
		this.garageType = garageType;
		this.fullBaths = fullBaths;
		this.halfBaths = halfBaths;
		this.pool = pool;
	}
	

	//getter & setter
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public Float getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(Float marketValue) {
		this.marketValue = marketValue;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public int getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getDwellingType() {
		return dwellingType;
	}
	public void setDwellingType(String dwellingType) {
		this.dwellingType = dwellingType;
	}
	public String getRoofMaterial() {
		return roofMaterial;
	}
	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}
	public String getGarageType() {
		return garageType;
	}
	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}
	public int getFullBaths() {
		return fullBaths;
	}
	public void setFullBaths(int fullBaths) {
		this.fullBaths = fullBaths;
	}
	public int getHalfBaths() {
		return halfBaths;
	}
	public void setHalfBaths(int halfBaths) {
		this.halfBaths = halfBaths;
	}
	public int getPool() {
		return pool;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}
	
	

}
