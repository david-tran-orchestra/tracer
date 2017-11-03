package com.orchestra.tracer.microservice.rest.server;

import com.orchestra.tracer.microservice.rest.client.LogRequestRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller will be used for READ PROCESSES ONLY
 * */
@RestController
@RequestMapping("/logRequest")
public class LogRequestController {

    @Autowired
    private LogRequestRestClient restClient;

}
