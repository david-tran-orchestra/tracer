package com.orchestra.tracer.slog.feeder.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilesConfig {
	
	@Value("${commons.tracer.slog.parser.path}")
	private String witnessFilesDirectory;
	
	@Value("${commons.tracer.slog.parser.path}")
	private String slogsFilesDirectory;
	
	@Bean
	public File witnessFilesDirectory() {
		File f = new File(witnessFilesDirectory);
		if(!f.exists())
			f.mkdirs();
		return f;
	}
	
	@Bean
	public File slogsFilesDirectory() {
		File f = new File(slogsFilesDirectory);
		if(!f.exists())
			f.mkdirs();
		return f;
	}

}
