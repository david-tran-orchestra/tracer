package com.orchestra.tracer.slog.feeder.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAccessor implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	public static ApplicationContext getContext() {
		return context;
	}
	
	@Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        context = ac;
    }

}
