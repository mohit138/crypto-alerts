package com.crypto.alert.models.response;

public class AlertRequest {
	

	
	
	public AlertRequest() {
		super();
	}
	public AlertRequest(long userId, String script, double price, int moreThan) {
		super();
		this.userId = userId;
		this.script = script;
		this.price = price;
		this.moreThan = moreThan;
	}
	private long userId;
	private String script;
	private double price;
	private int moreThan;
	
	public long getUserId() {
		return userId;
	}
	public String getScript() {
		return script;
	}
	public double getPrice() {
		return price;
	}
	public int getMoreThan() {
		return moreThan;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setMoreThan(int moreThan) {
		this.moreThan = moreThan;
	}
}
