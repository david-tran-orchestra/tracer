package com.orchestra.tracer.dtos.requests.insert;

/**
 * DTO to insert a detail log request.
 */
public class DetailsInsertLogRequest extends AbstractInsertLogRequest implements IInsertLogRequest {

	/** The log request. */
	private String logRequest;

	/** the log response. */
	private LogResponse logResponse;

	/** The log stack trace. */
	private String logStackTrace;

	/** The log dispo ref TO. */
	private String logDispoRefTo;


	//*************************************
	//*        GETTERS/SETTERS            *
	//*************************************

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

	public LogResponse getLogResponse() {
		return logResponse;
	}

	public void setLogResponse(LogResponse logResponse) {
		this.logResponse = logResponse;
	}
}
