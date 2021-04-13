package com.zetcode.driver;

import com.zetcode.bean.EPages;

public class _04DriverEpages {

	public static void main(String[] args) {
		
		EPages x = EPages.find("citychart");
		System.out.println(x);

	}

}
