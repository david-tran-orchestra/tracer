package com.orchestra.tracer.slog.feeder.actions;

public class LogInsertMappingObject<T> {
	
	private Class<T> c;
	
	public LogInsertMappingObject(Class<T> c) {
		this.c = c;
	}
	
	public Class<T> getTargetClass() {
		return c;
	}

}
