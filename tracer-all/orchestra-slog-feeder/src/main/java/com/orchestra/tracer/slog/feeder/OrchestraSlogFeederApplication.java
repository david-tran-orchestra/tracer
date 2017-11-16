package com.orchestra.tracer.slog.feeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orchestra.tracer.slog.feeder.actions.SLogParserProcessor;

//@EnableAsync
@SpringBootApplication
public class OrchestraSlogFeederApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrchestraSlogFeederApplication.class, args);
	}

	@Autowired
	private SLogParserProcessor slogParser;
	
	@Override
	public void run(String... args) throws Exception {
		slogParser.processSlogs();
		
	}
}
