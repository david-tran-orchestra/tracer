package com.orchestra.tracer.dtos.results;

public class TraceResultsContainer {
	
	TraceUserSessionResult[] userSessions;

	public TraceUserSessionResult[] getUserSessions() {
		return userSessions;
	}

	public void setUserSessions(TraceUserSessionResult[] userSessions) {
		this.userSessions = userSessions;
	}

}
