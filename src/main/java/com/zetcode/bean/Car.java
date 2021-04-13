package com.zetcode.bean;

import java.util.Objects;

public class Car {
    
    private Long id;
    private String name;
    private float price;
    private float vendorPrice;
    private float profit;

    public Car() {}

    

	public Car(Long id, String name, float price, float vendorprice, float profit) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vendorPrice = vendorprice;
		this.profit = profit;
	}


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getVendorprice() {
		return vendorPrice;
	}
    public float getProfit() {
		return profit;
	}

    

    public void setId(Long id) {
        this.id = id;
    }



	public void setName(String name) {
        this.name = name;
    }



	public void setPrice(float price) {
        this.price = price;
    }

	public void setVendorprice(float vendorprice) {
		this.vendorPrice = vendorprice;
	}



	public void setProfit(float profit) {
		this.profit = profit;
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", vendorprice=" + vendorPrice + ", profit="
				+ profit + "]";
	}
	
	

	
	
   
}