package com.zetcode.driver;

import com.zetcode.bean.Loan;

public class TestPayment {

	public static void main(String[] args) {
		
		float payment = Loan.calculateLoan(.055f, 360f, 61_500f);
		System.out.println(payment);

	}

}
