package com.orchestra.tracer.dtos.requests.insert;


/**
 * DTO to insert a log request.
 */
public class InsertLogRequest extends AbstractInsertLogRequest implements IInsertLogRequest {

	/** The session id. */
	protected String sessionId;

	/** The meta insert log request. */
	protected MetaInsertLogRequest metaInsertLogRequest;

	/** The details insert log request. */
	protected DetailsInsertLogRequest detailsInsertLogRequest;


	//*************************************
	//*        GETTERS/SETTERS            *
	//*************************************

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public MetaInsertLogRequest getMetaInsertLogRequest() {
		return metaInsertLogRequest;
	}

	public void setMetaInsertLogRequest(MetaInsertLogRequest metaInsertLogRequest) {
		this.metaInsertLogRequest = metaInsertLogRequest;
	}

	public DetailsInsertLogRequest getDetailsInsertLogRequest() {
		return detailsInsertLogRequest;
	}

	public void setDetailsInsertLogRequest(DetailsInsertLogRequest detailsInsertLogRequest) {
		this.detailsInsertLogRequest = detailsInsertLogRequest;
	}

	@Override
	public String toString() {
		return "InsertLogRequest [sessionId=" + sessionId + "]";
	}

}
