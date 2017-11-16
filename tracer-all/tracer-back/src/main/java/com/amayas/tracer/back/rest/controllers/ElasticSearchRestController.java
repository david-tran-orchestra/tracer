package com.amayas.tracer.back.rest.controllers;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amayas.tracer.back.elastic.services.SessionStepService;
import com.orchestra.tracer.dtos.requests.insert.MetaInsertLogRequest;
import com.orchestra.tracer.dtos.requests.search.TraceSearchRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;
import com.orchestra.tracer.dtos.results.TraceResultsContainer;
import com.orchestra.tracer.dtos.results.TraceSessionStepResult;

@RestController
@RequestMapping(RestMapping.LOGS_ES)
public class ElasticSearchRestController {
	
	@Autowired
	private SessionStepService sessionStepService;
	
	@GetMapping("/{id}")
	public Publisher<TraceSessionStepResult> loadUserSession(@PathVariable(value = "id") String id) {
		System.out.println("Received in tracer-back -> " + id);
		return sessionStepService.loadUserSession(id);
	}

	@PostMapping("/log")
	public Publisher<String> createLog(@RequestBody MetaInsertLogRequest req) {
		return sessionStepService.saveSessionStep(req);
	}
	
	@PostMapping("/search")
	public Publisher<TraceResultsContainer> loadUserSessionTrace(@RequestBody TraceSearchRequest req) {
		return sessionStepService.searchTraceUserSessions(req);
	}
	
}
