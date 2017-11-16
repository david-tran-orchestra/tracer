package com.amayas.tracer.back.elastic.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import com.amayas.tracer.back.elastic.entities.SessionStep;
import com.amayas.tracer.back.elastic.repositories.SessionStepRepository;
import com.amayas.tracer.back.mapping.LogMapper;
import com.orchestra.tracer.dtos.requests.insert.MetaInsertLogRequest;
import com.orchestra.tracer.dtos.requests.search.TraceSearchRequest;
import com.orchestra.tracer.dtos.results.TraceResultsContainer;
import com.orchestra.tracer.dtos.results.TraceSessionStepResult;
import com.orchestra.tracer.dtos.results.TraceUserStepResult;

@Service
public class SessionStepService {
	
	@Autowired
	private LogMapper sessionStepMapper;
	
	@Autowired
	private SessionStepRepository sessionStepRepository;
	

	public Mono<String> saveSessionStep(MetaInsertLogRequest req) {
		SessionStep ssd = sessionStepMapper.dtoToEntity(req);
		sessionStepRepository.save(ssd);
		return Mono.just(ssd.getId());
	}
	
	public Mono<TraceResultsContainer> searchTraceUserSessions(TraceSearchRequest req) {
		TraceResultsContainer results = new TraceResultsContainer();
		List<TraceSessionStepResult> sessionStepResults = sessionStepRepository.findByTypeAndProducerCodeAndProductCodeAndSessionIdAndStatusAndErrorCode(req.getTraceType(), req.getProducerCode(), req.getProductCode(), req.getSessionId(), req.getStatus(), req.getErrorCode()).stream().map(m -> sessionStepMapper.entityToDto(m)).collect(Collectors.toList());
		
		// grouping session steps by user session id
		Map<String, List<TraceSessionStepResult>> sessionStepsGroups = sessionStepResults.stream().collect(Collectors.groupingBy(g -> g.getSessionId()));
		
		// for each user session, let's create a TraceUserStepResult
		for(Map.Entry<String, List<TraceSessionStepResult>> sessionStepGroup : sessionStepsGroups.entrySet()) {
			TraceUserStepResult userStep = new TraceUserStepResult();
			userStep.setSessionSteps(sessionStepGroup.getValue().stream().toArray(ta -> new TraceSessionStepResult[ta]));
		}
		return Mono.just(results);
	}
	
	public Mono<TraceSessionStepResult> loadUserSession(String id) {
		return Mono.just(sessionStepMapper.entityToDto(sessionStepRepository.findById(id).get()));
	}

}
