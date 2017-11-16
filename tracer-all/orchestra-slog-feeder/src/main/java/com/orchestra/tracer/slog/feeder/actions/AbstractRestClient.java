package com.orchestra.tracer.slog.feeder.actions;

import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public abstract class AbstractRestClient {

	@Autowired
	private WebClient dbClient;

	@Autowired
	private Environment env;

	protected <T> T get(Class<T> c, Map<String, Object> params, String uri) {
		Mono<T> response = dbClient.get().uri(uri, params)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(c);
		return response.block();
	}

	protected <T> T post(Class<T> c, Object value, String uri) {
		Mono<T> response = dbClient.post().uri(uri)
				.headers(head -> createHeaders())
				.accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(value)).retrieve().bodyToMono(c);
		return response.block();
	}

	protected HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + getAuthenticationCredentials());
		return headers;
	}

	private String getAuthenticationCredentials() {
		String username = env.getProperty("");
		String password = env.getProperty("");

		String plainCreds = username + ":" + password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
		return new String(base64CredsBytes);
	}

}
