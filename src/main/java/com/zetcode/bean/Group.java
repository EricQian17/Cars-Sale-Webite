package com.zetcode.bean;

public class Group {
	
	 private String groupId;
	 private String name;
	 private String cityId;
	 private String purchaseMonth;
	 private float pricePaid;
	 private float vendorPrice;
	 private float income;
	 
	 public Group() {};
	 
	 public Group(String groupId, String name, String cityId, String purchaseMonth, float pricePaid, float vendorPrice,
			float income) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.cityId = cityId;
		this.purchaseMonth = purchaseMonth;
		this.pricePaid = pricePaid;
		this.vendorPrice = vendorPrice;
		this.income = income;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getPurchaseMonth() {
		return purchaseMonth;
	}

	public void setPurchaseMonth(String purchaseMonth) {
		this.purchaseMonth = purchaseMonth;
	}

	public float getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(float pricePaid) {
		this.pricePaid = pricePaid;
	}

	public float getVendorPrice() {
		return vendorPrice;
	}

	public void setVendorPrice(float vendorPrice) {
		this.vendorPrice = vendorPrice;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", name=" + name + ", cityId=" + cityId + ", purchaseMonth="
				+ purchaseMonth + ", pricePaid=" + pricePaid + ", vendorPrice=" + vendorPrice + ", income=" + income
				+ "]";
	}
	 
	 
	 
	 
	 
	 
	 

}
