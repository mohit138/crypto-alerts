package com.crypto.alert.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crypto.alert.models.Alert;
import com.crypto.alert.models.ExchangeData;
import com.crypto.alert.models.ExecutedAlert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Component
public class AlertChecker {
	
	
	@Scheduled(fixedDelay = 500)
	public void alertChecker() {

    	List<Alert> btcAlerts = null;
    	ExchangeData btcExchangeData = null;
	    
    	final String excahngePriceUri = "https://api.coinbase.com/v2/prices/BTC-INR/buy";
    	final String getAlertsUrl = "http://localhost:8080/active-alerts/BTC";
    	
	    try {
	    	btcAlerts = getAlertsFromDb(getAlertsUrl);
		    
		} catch (Exception e) {
		}
	    
	    try {
	    	btcExchangeData = getExchangeData(excahngePriceUri);
	    	System.out.println(btcExchangeData.getData().getAmount());
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    // PERFORMING CHECKING AND EXECUTION
	    if(btcAlerts != null) {
		    for(Alert alert: btcAlerts) {
		    	if(checkIfExecuted(alert, btcExchangeData)) {
		    		try {
		    			executeAlert(alert);
		    		} catch(Exception e) {
		    			System.out.println("Issue encountered in executing alert!");
		    		}
		    	}
		    }
	    }

	    
	}
	
	private List<Alert> getAlertsFromDb(String getAlertsUrl) throws JsonMappingException, JsonProcessingException{
		RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper objectMapper = new ObjectMapper();
	    TypeFactory typeFactory = objectMapper.getTypeFactory();
		ResponseEntity<String> response= restTemplate.getForEntity(getAlertsUrl, String.class);
	    String alertsString = response.getBody();
	    List<Alert> alerts = objectMapper.readValue(alertsString, typeFactory.constructCollectionType(List.class, Alert.class));
	    return alerts;
	}
	
	private ExchangeData getExchangeData(String excahngePriceUri) throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper objectMapper = new ObjectMapper();
	    TypeFactory typeFactory = objectMapper.getTypeFactory();
	    ResponseEntity<String> response= restTemplate.getForEntity(excahngePriceUri, String.class);
	    String exchnageDataString = response.getBody();
	    ExchangeData exchangeData = objectMapper.readValue(exchnageDataString,ExchangeData.class);
	    return exchangeData;	    
	}
	
	private boolean checkIfExecuted(Alert alert, ExchangeData exchangeData) {
		boolean executeFlag=false;
		double exchangePrice = exchangeData.getData().getAmount();
		int moreThan = alert.getMoreThan();
		if(moreThan == 1) {
			if(alert.getPrice() < exchangePrice) {
				executeFlag=true;
			}
		}else {
			if(alert.getPrice() > exchangePrice) {
				executeFlag=true;
			}
		}
		
		return executeFlag;
	}
	
	private void executeAlert(Alert alert) throws Exception {
		
		System.out.println("EXECUTING FOLLOWING ALERT : \n" + alert.getAlertId());
		
		RestTemplate restTemplate = new RestTemplate();
//		 save this alert to history repo
		String addExecutedAlertUri = "http://localhost:8080/add-executed-alert";
		HttpEntity<ExecutedAlert> addExecutedAlertRequest = new HttpEntity<ExecutedAlert>(new ExecutedAlert(alert));
		ResponseEntity<String> addExecutedAlertResponse = restTemplate
                .exchange(addExecutedAlertUri, 
                        HttpMethod.POST, 
                        addExecutedAlertRequest, 
                        String.class);
		System.out.println("Following Alert is executed and stored in history : "+addExecutedAlertResponse);
		
		// delete from aler repo
		String deleteAlertUri = "http://localhost:8080/delete-alert";
		HttpEntity<Alert> deleteExecutedAlertRequest = new HttpEntity<Alert>(alert);
		ResponseEntity<String> deleteExecutedAlertResponse = restTemplate
                .exchange(deleteAlertUri, 
                        HttpMethod.DELETE, 
                        deleteExecutedAlertRequest, 
                        String.class);
//		restTemplate.delete(deleteAlertUri, alert);
		System.out.println("Following Alert is deleted from active alerts : id = "+ deleteExecutedAlertResponse);
		
	}
	
}
