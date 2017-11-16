package com.orchestra.tracer.dtos.results;

import com.orchestra.tracer.dtos.enums.SubTypeEnum;

/**
 * Created by David on 26/10/2017.
 */
public class TraceUserStepResult {
	
	private TraceSessionStepResult[] sessionSteps;
	
	private SubTypeEnum subType;

	public SubTypeEnum getSubType() {
		return subType;
	}

	public void setSubType(SubTypeEnum subType) {
		this.subType = subType;
	}

	public TraceSessionStepResult[] getSessionSteps() {
		return sessionSteps;
	}

	public void setSessionSteps(TraceSessionStepResult[] sessionSteps) {
		this.sessionSteps = sessionSteps;
	}
}
