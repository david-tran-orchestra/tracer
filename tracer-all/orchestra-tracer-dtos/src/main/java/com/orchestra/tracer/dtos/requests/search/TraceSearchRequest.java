package com.orchestra.tracer.dtos.requests.search;

import java.time.Period;

import com.orchestra.tracer.dtos.enums.ErrorCodeEnum;
import com.orchestra.tracer.dtos.enums.StatusEnum;
import com.orchestra.tracer.dtos.enums.TypeEnum;


public class TraceSearchRequest {
	
	private TypeEnum traceType;
	
	private boolean technical;
	
	private String producerCode;
	
	private String productCode;
	
	private String sessionId;
	
	private Period period;
	
	private StatusEnum status;
	
	private ErrorCodeEnum errorCode;

	public TypeEnum getTraceType() {
		return traceType;
	}

	public void setTraceType(TypeEnum traceType) {
		this.traceType = traceType;
	}

	public boolean isTechnical() {
		return technical;
	}

	public void setTechnical(boolean technical) {
		this.technical = technical;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodeEnum errorCode) {
		this.errorCode = errorCode;
	}

	public String getProducerCode() {
		return producerCode;
	}

	public void setProducerCode(String producerCode) {
		this.producerCode = producerCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	

}
