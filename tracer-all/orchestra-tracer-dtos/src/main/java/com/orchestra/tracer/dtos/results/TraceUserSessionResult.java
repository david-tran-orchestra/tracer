package com.orchestra.tracer.dtos.results;

public class TraceUserSessionResult {

    private String sessionId;
    
    private TraceUserStepResult[] userStepResults;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public TraceUserStepResult[] getUserStepResults() {
		return userStepResults;
	}

	public void setUserStepResults(TraceUserStepResult[] userStepResult) {
		this.userStepResults = userStepResult;
	}


}
