package com.orchestra.tracer.microservice.kafka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.microservice.rest.client.LogRequestRestClient;

public class KafkaReceiver {

    @Autowired
    private LogRequestRestClient restClient;
    
    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(InsertLogRequest req) {
        restClient.saveLogs(req);
    }


}
