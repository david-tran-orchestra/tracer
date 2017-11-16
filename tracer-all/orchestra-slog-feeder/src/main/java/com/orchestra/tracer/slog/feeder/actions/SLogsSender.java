package com.orchestra.tracer.slog.feeder.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;

@Service
public class SLogsSender {
	
	@Value("${kafka.topic.json}")
    private String topic;
	
	@Autowired
	private KafkaTemplate<String, InsertLogRequest> sLogsKafkaTemplate;
	
	public void send(InsertLogRequest payload) {
		sLogsKafkaTemplate.send(topic, payload);
	}

}
