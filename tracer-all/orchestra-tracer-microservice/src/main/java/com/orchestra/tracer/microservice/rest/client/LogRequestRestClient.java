package com.orchestra.tracer.microservice.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.dtos.rest.mappings.RestMapping;

/**
 * This class is in charge of calling our ES/MongoDB webservice for READ OR
 * WRITE
 * */
@Component
public class LogRequestRestClient {

	@Autowired
	private WebClient dbClient;

	public String saveLogDetails(InsertLogRequest req) {
		Mono<String> resp = dbClient
				.post()
				.uri(RestMapping.LOGS_MONGO_INSERT_DETAILS)
				.body(BodyInserters.fromObject(req.getDetailsInsertLogRequest()))
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(String.class);
		return resp.block();
	}

	public String saveLogMeta(InsertLogRequest req) {
		String logDetailsId = saveLogDetails(req);
		req.getMetaInsertLogRequest().setDetailsId(logDetailsId);
		Mono<String> resp = dbClient.post()
				.uri(RestMapping.LOGS_ES_INSERT_METAS)
				.body(BodyInserters.fromObject(req.getMetaInsertLogRequest()))
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(String.class);
		return resp.block();
	}
}
