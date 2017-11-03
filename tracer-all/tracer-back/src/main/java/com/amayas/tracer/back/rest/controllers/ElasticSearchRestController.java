package com.amayas.tracer.back.rest.controllers;

import com.amayas.tracer.back.elastic.services.SessionStepService;
import com.orchestra.tracer.dtos.requests.insert.MetaInsertLogRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestMapping.LOGS_ES)
public class ElasticSearchRestController {
	
	@Autowired
	private SessionStepService sessionStepService;

	@PostMapping("/log")
	public String createLog(MetaInsertLogRequest req) {
		sessionStepService.saveSessionSteps(req);
		return req.toString();
	}
	
}
