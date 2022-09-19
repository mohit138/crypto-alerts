package com.crypto.alert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crypto.alert.models.Alert;
import com.crypto.alert.models.response.AlertRequest;
import com.crypto.alert.repository.AlertRepository;
import com.crypto.alert.services.utils.AlertGenerator;

@Service
public class CreateAlertService {
	//this service should create an alert
	
	@Autowired
	private AlertRepository repository;
	
	@Autowired
	AlertGenerator alertGenerator;
	
	public Alert createAlert(AlertRequest newAlertRequest) throws Exception {
		
		List<Alert> alerts = repository.findAll();
		
		boolean existsFlag = false;
		if(alerts != null) {
			for(Alert a:alerts) {
				if(a.getUserId() == newAlertRequest.getUserId() && a.getScript().equals(newAlertRequest.getScript()) && a.getMoreThan() == newAlertRequest.getMoreThan() && a.getPrice() == newAlertRequest.getPrice()) {
					existsFlag = true;
				}
			}
		}

		
		if(existsFlag) {
			throw new Exception("Cannot Add, Because the alert already exists !"); 
		}
		
		Alert newAlert = alertGenerator.alertGenerator(newAlertRequest);
		
		return repository.save(newAlert);
		
	}
	


}


