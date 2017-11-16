package com.orchestra.tracer.microservice.rest.config;

import javax.net.ssl.SSLException;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfig {

    @Value("${web.client.url}")
    private String webClientUrl;

    @Bean
    public WebClient dbClient() throws SSLException {
//        WebClient wc = WebClient.create(webClientUrl);
    	SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
    	ClientHttpConnector httpConnector = new ReactorClientHttpConnector(opt -> opt.sslContext(sslContext));
        WebClient wc = WebClient.builder().clientConnector(httpConnector).baseUrl(webClientUrl).build();
        return wc;
    }
}
