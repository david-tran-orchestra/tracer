package com.orchestra.tracer.dtos.requests.insert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import com.orchestra.tracer.dtos.utils.DtosConstants;

public class LogResponse {
	
	private String logResponse;
	
	private boolean compressed;
	
	private byte[] compressedResponse;

	public byte[] getCompressedResponse() {
		return compressedResponse;
	}

	public void setCompressedResponse(byte[] compressedResponse) {
		this.compressedResponse = compressedResponse;
	}

	public String getLogResponse() {
		return logResponse;
	}

	public void setLogResponse(String logRequest) {
		this.logResponse = logRequest;
	}

	public boolean isCompressed() {
		return compressed;
	}

	public void setCompressed(boolean compressed) {
		this.compressed = compressed;
	}
	
	public LogResponse buildCompressedResponse(String responseStr, ByteArrayOutputStream bos, int compressionMinimalSize) throws IOException {
		if(responseStr.length() < compressionMinimalSize) {
			setLogResponse(responseStr);
			setCompressed(false);
			return this;
		}
		GZIPOutputStream gzip = null;
		try {
			bos = new ByteArrayOutputStream();
			gzip = new GZIPOutputStream(bos);
			gzip.write(responseStr.getBytes(DtosConstants.UTF_8));
			gzip.finish();
			gzip.flush();
			this.logResponse = null;
			this.compressedResponse = bos.toByteArray();
			this.compressed = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// TODO : enough ? never closed ?? --> let's see with @Michael Merkel
			bos.reset();
			gzip.close();
		}
		return this;
	}

}
