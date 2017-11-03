package com.amayas.tracer.back.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amayas.tracer.back.mongodb.services.SessionStepDetailsService;
import com.orchestra.tracer.dtos.requests.insert.DetailsInsertLogRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;

@RestController
@RequestMapping(RestMapping.LOGS_MONGO)
public class MongoDbRestController {
	
	@Autowired
	private SessionStepDetailsService sessionStepDetailsService;
	
	/**
	 * 
	 * */
	@PostMapping("/details")
	public String loadRequest(DetailsInsertLogRequest detailsDto) {
		return sessionStepDetailsService.saveSessionStepDetails(detailsDto);
	}

}
