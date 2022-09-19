package com.crypto.alert.models;

public class ExchangeDataDetails {
	
	
	public ExchangeDataDetails() {
		super();
	}
	public ExchangeDataDetails(String base, String currency, double amount) {
		super();
		this.base = base;
		this.currency = currency;
		this.amount = amount;
	}
	
	private String base;
	private String currency;
	private double amount;
	
	
	public String getBase() {
		return base;
	}
	public String getCurrency() {
		return currency;
	}
	public double getAmount() {
		return amount;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
