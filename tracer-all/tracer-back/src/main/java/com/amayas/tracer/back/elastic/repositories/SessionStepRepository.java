package com.amayas.tracer.back.elastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.amayas.tracer.back.elastic.entities.SessionStep;
import com.orchestra.tracer.dtos.enums.ErrorCodeEnum;
import com.orchestra.tracer.dtos.enums.StatusEnum;
import com.orchestra.tracer.dtos.enums.TypeEnum;

public interface SessionStepRepository extends ElasticsearchRepository<SessionStep, String> {
	
	public SessionStep findBySessionId(String sessionId);
	
	public List<SessionStep> findByTypeAndProducerCodeAndProductCodeAndSessionIdAndStatusAndErrorCode(TypeEnum traceType, String producerCode, String productCode, String sessionId, StatusEnum status, ErrorCodeEnum errorCode);

}
