package com.crypto.alert.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.alert.models.Alert;
import com.crypto.alert.models.response.AlertRequest;
import com.crypto.alert.repository.AlertRepository;
import com.crypto.alert.services.CreateAlertService;
import com.crypto.alert.services.DeleteAlertService;

@RestController
public class AlertController {
	private final AlertRepository repository;
	
	@Autowired
	CreateAlertService createAlertService;
	
	@Autowired
	DeleteAlertService deleteAlertService;

	public AlertController(AlertRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/active-alerts")
	List<Alert> getExistingAlerts() {
		return repository.findAll();
	}
	
	@GetMapping("/active-alerts/{cur}")
	List<Alert> getCurrencySpecificAlerts(@PathVariable String cur) {
		return repository.findAllByScript(cur);
	}
	
	
	@PostMapping("/add-alert")
	Alert addAlert(@RequestBody AlertRequest newAlertRequest) throws Exception {
		Alert createdAlert = createAlertService.createAlert(newAlertRequest);
		return createdAlert;

	}
	
	
	@DeleteMapping("/delete-alert")
	void deleteAlert(@RequestBody AlertRequest alertRequest) {
		deleteAlertService.deleteAlertService(alertRequest);
	}
	
	@DeleteMapping("/delete-alert-byId/{id}")
	Optional<Alert> deleteAlertById(@PathVariable long id) throws Exception {
		Optional<Alert> alert = repository.findById(id);
		repository.deleteById(id);
		
		if(alert == null) {
			throw new Exception("Cannot delete as it doesnot exist!");
		}else {
			return alert;
		}

	}
	
	
}