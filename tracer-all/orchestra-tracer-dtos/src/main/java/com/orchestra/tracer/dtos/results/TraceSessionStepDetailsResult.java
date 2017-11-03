package com.orchestra.tracer.dtos.results;

public class TraceSessionStepDetailsResult {
	
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
	
	

}
