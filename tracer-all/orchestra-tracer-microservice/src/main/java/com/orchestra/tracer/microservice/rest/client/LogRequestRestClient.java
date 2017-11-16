package com.orchestra.tracer.microservice.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.dtos.requests.search.TraceSearchRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;
import com.orchestra.tracer.dtos.results.TraceSessionStepDetailsResult;
import com.orchestra.tracer.dtos.results.TraceSessionStepResult;
import com.orchestra.tracer.dtos.results.TraceUserSessionResult;

/**
 * This class is in charge of calling our ES/MongoDB API for READ OR WRITE
 * */
@Component
public class LogRequestRestClient {

	@Autowired
	private WebClient dbClient;

	public void saveLogs(InsertLogRequest req) {
		// save details first to get MongoDB saved entity id
		Mono<String> resp = dbClient
				.post()
				.uri(RestMapping.LOGS_MONGO_INSERT_DETAILS)
				.body(BodyInserters.fromObject(req.getDetailsInsertLogRequest()))
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(String.class);

		// subscribe to the returned value :
		// when the result is returned, let's call the method who saves
		// the log meta-data
		resp.subscribe(mongoIdStr -> saveLogMeta(req, mongoIdStr));
	}

	public void saveLogMeta(InsertLogRequest req, String mongoIdStr) {
		req.getMetaInsertLogRequest().setDetailsId(mongoIdStr);
		Mono<String> resp = dbClient.post()
				.uri(RestMapping.LOGS_ES_INSERT_METAS)
				.body(BodyInserters.fromObject(req.getMetaInsertLogRequest()))
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(String.class);

		// necessary to execute process on server side
		resp.subscribe();
	}

	public Mono<TraceUserSessionResult> loadUserSessionTrace(
			TraceSearchRequest req) {
		Mono<TraceUserSessionResult> resp = dbClient.post()
				.uri(RestMapping.LOGS_ES_SEARCH_LOGS)
				.body(BodyInserters.fromObject(req))
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(TraceUserSessionResult.class);
//		resp.subscribe();
		return resp;
	}

	public Mono<TraceSessionStepDetailsResult> loadSessionStepDetails(String id) {
		Mono<TraceSessionStepDetailsResult> resp = dbClient.get()
				.uri(RestMapping.LOGS_MONGO_LOAD_DETAILS, id)
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(TraceSessionStepDetailsResult.class);
//		resp.subscribe();
		return resp;
	}

	public Mono<TraceSessionStepResult> loadSessionStepById(String id) {
		Mono<TraceSessionStepResult> resp = dbClient.get()
				.uri(RestMapping.LOGS_ES_FIND_BY_ID, id)
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(TraceSessionStepResult.class);
//		resp.subscribe();
		return resp;
	}

}
