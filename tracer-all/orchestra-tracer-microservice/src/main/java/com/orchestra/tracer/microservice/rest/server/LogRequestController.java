package com.orchestra.tracer.microservice.rest.server;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchestra.tracer.dtos.requests.search.TraceSearchRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;
import com.orchestra.tracer.dtos.results.TraceSessionStepDetailsResult;
import com.orchestra.tracer.dtos.results.TraceSessionStepResult;
import com.orchestra.tracer.dtos.results.TraceUserSessionResult;
import com.orchestra.tracer.microservice.rest.client.LogRequestRestClient;

/**
 * This controller will be used for READ PROCESSES ONLY
 * */
@RestController
@RequestMapping(RestMapping.LOGS_MS)
public class LogRequestController {

    @Autowired
    private LogRequestRestClient restClient;
    
    @PostMapping("/meta")
    public Publisher<TraceUserSessionResult> loadUserSession(TraceSearchRequest req) {
    	return restClient.loadUserSessionTrace(req);
    }
    
    @GetMapping("/mongo/{id}")
    public Publisher<TraceSessionStepDetailsResult> loadDetailsById(@PathVariable(value = "id", required = true) String id) {
    	System.out.println("sent to mongo = " + id);
    	return restClient.loadSessionStepDetails(id);
    }
    
    @GetMapping("/es/{id}")
    public Publisher<TraceSessionStepResult> loadSessionStepById(@PathVariable(value = "id", required = true) String id) {
    	System.out.println("sent to es = " + id);
    	return restClient.loadSessionStepById(id);
    }
    

}
