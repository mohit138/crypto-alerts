package com.crypto.alert.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="alerts-history")
public class ExecutedAlert {
	
	public ExecutedAlert() {
		
	}
	
	public ExecutedAlert(UUID alertId,long userId, String script, double price, int moreThan) {
		super();
		this.alertId = alertId;
		this.userId = userId;
		this.script = script;
		this.price = price;
		this.moreThan = moreThan;
		
		this.date = new Date();
	}
	
	public ExecutedAlert(Alert alert) {
		super();
		this.alertId = alert.getAlertId();
		this.userId = alert.getUserId();
		this.script = alert.getScript();
		this.price = alert.getPrice();
		this.moreThan = alert.getMoreThan();
		
		this.date = new Date();
	}
	
	
	@Id
	private UUID alertId;
	private long userId;
	private String script;
	private double price;
	private int moreThan;
	private Date date;
	
	public UUID getAlertId() {
		return alertId;
	}
	public void setAlertId(UUID alertId) {
		this.alertId = alertId;
	}
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
