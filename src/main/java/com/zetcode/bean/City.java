package com.zetcode.bean;

public class City {
	
	private String cityId;
	private String regionName;
	private float income;
	
	public City(String cityId, String regionName,float income) {
		this.cityId = cityId;
		this.regionName = regionName;
		this.income = income;
	}

	public City(String cityId, String regionName) {
		this.cityId = cityId;
		this.regionName = regionName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", regionName=" + regionName + ", income=" + income + "]";
	}
	
	
	
	
	

}
