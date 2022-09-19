package com.crypto.alert.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.crypto.alert.models.Alert;

public interface AlertRepository extends MongoRepository<Alert, Long> {
	
	@Query("{script:'?0'}")
    Alert findItemByName(String script);

	
	@Query("{'userId':?0 , 'script':?1, 'price':?2, 'moreThan':?3}")
	Alert findUniqueAlert(long userId, String script, double price, int moreThan);
	
	@Query("{'script':?0}")
	List<Alert> findAllByScript(String script);

//	void deleteByUserId(long userId)
	long count();
}
