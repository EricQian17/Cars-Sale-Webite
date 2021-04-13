package com.zetcode.bean;

public class Loan {
	private int times;
	private float amount;
    private float payment;
    
    public Loan() {}
    
	public Loan(int times,float amount, float payment) {
		super();
		this.times = times;
		this.amount = amount;
		this.payment = payment;
	}
	

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}
	public static float calculateLoan(float annualRate, float terms, float financeAmount)
	{
		double fv = financeAmount * Math.pow((1 + annualRate/12), terms);
		double monthlyPament  = (fv * annualRate/12) / (Math.pow((1 + annualRate/12), terms) - 1);

		return (float) monthlyPament;
	}

	@Override
	public String toString() {
		return "Loan [amount=" + amount + ", payment=" + payment + "]";
	}
	
	
    
    
}
