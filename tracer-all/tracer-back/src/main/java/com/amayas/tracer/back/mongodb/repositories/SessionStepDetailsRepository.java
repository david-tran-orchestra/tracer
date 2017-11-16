package com.amayas.tracer.back.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amayas.tracer.back.mongodb.entities.SessionStepDetails;

public interface SessionStepDetailsRepository extends MongoRepository<SessionStepDetails, Long> {

	public SessionStepDetails findById(String id);
	
}
