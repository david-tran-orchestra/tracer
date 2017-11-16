package com.orchestra.tracer.dtos.enums;

public enum StatusEnum {
	
	OK, KO;
	
	public static StatusEnum fromString(String s) {
		for(StatusEnum se : values())
			if(se.name().equals(s))
				return se;
		return OK;
	}

}
