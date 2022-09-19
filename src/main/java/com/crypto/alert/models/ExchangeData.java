package com.crypto.alert.models;

public class ExchangeData {
	
	
	
	public ExchangeData() {
		super();
	}

	public ExchangeData(ExchangeDataDetails data) {
		super();
		this.data = data;
	}
	
	private ExchangeDataDetails data;

	public ExchangeDataDetails getData() {
		return data;
	}

	public void setData(ExchangeDataDetails data) {
		this.data = data;
	}
	
}
