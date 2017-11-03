package com.amayas.tracer.back.mongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "sessionStepRequests")
public class SessionStepDetails {
	
	@Id
	private String id;

	private String logRequest;
	
	private String logResponse;
	
	private String logStackTrace;
	
	private String logDispoRefTo;

	public String getLogStackTrace() {
		return logStackTrace;
	}

	public void setLogStackTrace(String logStackTrace) {
		this.logStackTrace = logStackTrace;
	}

	public String getLogDispoRefTo() {
		return logDispoRefTo;
	}

	public void setLogDispoRefTo(String logDispoRefTo) {
		this.logDispoRefTo = logDispoRefTo;
	}

	public String getLogRequest() {
		return logRequest;
	}

	public void setLogRequest(String logRequest) {
		this.logRequest = logRequest;
	}

	public String getLogResponse() {
		return logResponse;
	}

	public void setLogResponse(String logResponse) {
		this.logResponse = logResponse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
