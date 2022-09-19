package com.crypto.alert.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crypto.alert.models.Alert;
import com.crypto.alert.models.response.AlertRequest;
import com.crypto.alert.repository.AlertRepository;

@Service
public class DeleteAlertService {
	
	@Autowired AlertRepository repository;
	
	public void deleteAlertService(AlertRequest alertRequest) {
		Alert alertToRemove = repository.findUniqueAlert(alertRequest.getUserId(), alertRequest.getScript(), alertRequest.getPrice(), alertRequest.getMoreThan());
		repository.delete(alertToRemove);
	}

}
