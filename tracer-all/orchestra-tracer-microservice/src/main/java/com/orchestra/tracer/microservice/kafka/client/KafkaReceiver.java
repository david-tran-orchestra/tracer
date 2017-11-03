package com.orchestra.tracer.microservice.kafka.client;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.microservice.rest.client.LogRequestRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReceiver {

    @Autowired
    private LogRequestRestClient restClient;

    @KafkaListener(topics = "${kafka.topic.helloworld}")
    public void receive(InsertLogRequest req) {
        restClient.saveLogMeta(req);
    }


}
