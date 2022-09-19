package com.crypto.alert.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.crypto.alert.models.ExecutedAlert;

public interface ExecutedAlertRepository extends MongoRepository<ExecutedAlert, Long> {
	
	@Query("{script:'?0'}")
	ExecutedAlert findItemByName(String script);

	
	@Query("{'userId':?0 , 'script':?1, 'price':?2, 'moreThan':?3}")
	ExecutedAlert findUniqueAlert(long userId, String script, double price, int moreThan);
	
	@Query("{'script':?0}")
	List<ExecutedAlert> findAllByScript(String script);

//	void deleteByUserId(long userId)
	long count();
}