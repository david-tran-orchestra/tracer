package com.amayas.tracer.back.elastic.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.amayas.tracer.back.elastic.entities.SessionStep;

public interface SessionStepRepository extends ElasticsearchRepository<SessionStep, String> {
	
	public SessionStep findBySessionId(String sessionId);

}
