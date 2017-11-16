package com.amayas.tracer.back.mongodb.entities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.orchestra.tracer.dtos.requests.insert.LogResponse;
import com.orchestra.tracer.dtos.utils.DtosConstants;


@Document(collection = "sessionStepRequests")
public class SessionStepDetails {
	
	@Id
	private String id;

	private String logRequest;
	
	private String logResponse;
	
	private String logStackTrace;
	
	private String logDispoRefTo;
	
	public void buildResponse(LogResponse response) {
		// if the response has not been compressed, let's get it as such
		if(response == null)
			return;
		if(!response.isCompressed()) {
			this.logResponse = response.getLogResponse();
			return;
		}
		
		ByteArrayInputStream bis = null;
		GZIPInputStream gzip = null;
		try {
			// if the response content has been compressed, let's uncompress it
			bis = new ByteArrayInputStream(response.getCompressedResponse());
			gzip = new GZIPInputStream (bis);
			StringWriter sw = new StringWriter();
			IOUtils.copy(gzip, sw, DtosConstants.UTF_8);
			this.logResponse = sw.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(gzip != null)
					gzip.close();
				if(bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
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
