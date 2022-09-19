package com.crypto.alert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.crypto.alert.controller.AlertController;
import com.crypto.alert.models.Alert;
import com.crypto.alert.models.response.AlertRequest;
import com.crypto.alert.repository.AlertRepository;
import com.crypto.alert.services.CreateAlertService;
import com.crypto.alert.services.utils.AlertGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers=AlertController.class)
public class AlertControllerTests  {

	@MockBean
	CreateAlertService createAlertService;
	
	@Autowired
	private MockMvc mvc;
	
//	@Override
//	@Before
//	public void setUp() {
//		super.setUp();
//	}

//	@Test
//	public void getAlerts() throws Exception {
//		String uri = "/active-alerts";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Alert[] alertlist = super.mapFromJson(content, Alert[].class);
//		System.out.println(alertlist);
//		assertTrue(alertlist.length > 0);
//	}

//	@Test
//	public void createAlert() throws Exception {
//		
//		String uri = "/add-alert";
//		String uuidString1="uuid1";
//		UUID randomUUID1 = UUID.nameUUIDFromBytes(uuidString1.getBytes());
//		AlertRequest alertRequest = new AlertRequest(123456, "BTC", 100.2, 1);
//		Alert alert = new Alert(randomUUID1,123456, "BTC", 100.2, 1);
//		Mockito.when(createAlertService.createAlert(alertRequest)).thenReturn(new Alert(randomUUID1,123456, "BTC", 100.2, 1));
//		
//		
//		
//		String inputJson = new ObjectMapper().writeValueAsString (alertRequest);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//
//		assertEquals(content, alert.toString());
//
//	}
	
	
}
