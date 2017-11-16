package com.orchestra.tracer.slog.feeder.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.util.StringUtils;

public class SLogFile extends File {
	private static final long serialVersionUID = 1L;
	
	public SLogFile(String path) {
		super(path);
	}
	
	public SLogFile(File f) {
		super(f.getAbsolutePath());
	}
	
	public String[] toLines() {
		String[] lines = new String[]{};
		try {
			if(!StringUtils.isEmpty(getAbsolutePath()))
				lines =  Files.lines(Paths.get(getAbsolutePath())).toArray(ta -> new String[ta]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
