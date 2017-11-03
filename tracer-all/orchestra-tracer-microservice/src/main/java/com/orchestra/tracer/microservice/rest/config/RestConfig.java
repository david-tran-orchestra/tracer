package com.orchestra.tracer.microservice.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfig {

    @Value("${web.client.url}")
    private String webClientUrl;

    @Bean
    public WebClient dbClient() {
        WebClient wc = WebClient.create(webClientUrl);
        return wc;
    }
}
