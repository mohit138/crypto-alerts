package com.crypto.alert.services.utils;

import org.springframework.stereotype.Service;

import com.crypto.alert.models.Alert;
import com.crypto.alert.models.response.AlertRequest;

@Service
public class AlertGenerator {

	public Alert alertGenerator(AlertRequest alertRequest) {
		Alert alert = new Alert(alertRequest);
		return alert;
	}
}
