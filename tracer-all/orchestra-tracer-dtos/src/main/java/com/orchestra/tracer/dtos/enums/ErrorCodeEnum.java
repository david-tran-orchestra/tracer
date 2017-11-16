package com.orchestra.tracer.dtos.enums;

public enum ErrorCodeEnum {
	
	CLIENT_FORBIDDEN("404"), SERVER_FORBIDDEN("500");
	
	private final String s;
	
	private ErrorCodeEnum(String s) {
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s;
	}
	
	public static ErrorCodeEnum findFromString(String s) {
		for(ErrorCodeEnum err : values())
			if(err.toString().equals(s))
				return err;
		return null;
	}
	

}
