package com.amayas.tracer.back.rest.controllers;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import com.amayas.tracer.back.mongodb.services.SessionStepDetailsService;
import com.orchestra.tracer.dtos.requests.insert.DetailsInsertLogRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;
import com.orchestra.tracer.dtos.results.TraceSessionStepDetailsResult;

@RestController
@RequestMapping(RestMapping.LOGS_MONGO)
public class MongoDbRestController {
	
	@Autowired
	private SessionStepDetailsService sessionStepDetailsService;
	
	/**
	 * Inserts LOGS in MongoDB 
	 * */
	@PostMapping("/details")
	public Publisher<String> loadRequest(@RequestBody DetailsInsertLogRequest detailsDto) {
		String s = sessionStepDetailsService.saveSessionStepDetails(detailsDto);
		return Mono.just(s);
	}
	
	/**
	 * Loads LOG with given @id
	 * */
	@GetMapping("/{id}")
	public Publisher<TraceSessionStepDetailsResult> loadDetailsById(@PathVariable(value = "id", required = true) String id) {
		return Mono.just(sessionStepDetailsService.loadDetailsById(id));
	}

}
