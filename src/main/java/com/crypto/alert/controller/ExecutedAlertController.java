package com.crypto.alert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.alert.models.Alert;
import com.crypto.alert.models.ExecutedAlert;
import com.crypto.alert.repository.ExecutedAlertRepository;

@RestController
public class ExecutedAlertController {
	private final ExecutedAlertRepository repository;

	public ExecutedAlertController(ExecutedAlertRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/alerts-history")
	List<ExecutedAlert> getExecutedAlerts(){
		return repository.findAll();
	}
	
	@PostMapping("/add-executed-alert")
	ExecutedAlert addAlert(@RequestBody Alert executedAlert) throws Exception {
				
		ExecutedAlert newExecutedAlert = new ExecutedAlert(executedAlert);
		
		return repository.save(newExecutedAlert);
	}
	
	
	
	
}
