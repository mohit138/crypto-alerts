package com.crypto.alert.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.crypto.alert.models.response.AlertRequest;

@Document(collection="alerts")
public class Alert {
	
	public Alert() {
		
	}
	
	public Alert(UUID alertId,long userId, String script, double price, int moreThan) {
		super();
		this.alertId = alertId;
		this.userId = userId;
		this.script = script;
		this.price = price;
		this.moreThan = moreThan;
	}
	
	public Alert(AlertRequest alertResponse) {
		super();
		this.alertId = UUID.randomUUID();
		this.userId = alertResponse.getUserId();
		this.script = alertResponse.getScript();
		this.price = alertResponse.getPrice();
		this.moreThan = alertResponse.getMoreThan();
	}
	
	
	
	@Id
	private UUID alertId;
	private long userId;
	private String script;
	private double price;
	private int moreThan;
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

	@Override
	public String toString() {
		return "Alert [alertId=" + alertId + ", userId=" + userId + ", script=" + script + ", price=" + price
				+ ", moreThan=" + moreThan + "]";
	}

	
	
	
}
