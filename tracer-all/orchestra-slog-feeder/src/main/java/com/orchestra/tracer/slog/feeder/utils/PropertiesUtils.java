package com.orchestra.tracer.slog.feeder.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertiesUtils {
	
	@Autowired
	private Environment env;
	
	public String getProperty(String key) {
		return env.getProperty(key);
	}
	
	public int getMinimalSizeCompression() {
		return Integer.valueOf(getProperty("commons.tracer.slog.parser.minimal.string.size.compression"));
	}

}
