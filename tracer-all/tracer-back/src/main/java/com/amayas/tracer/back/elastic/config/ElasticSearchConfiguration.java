package com.amayas.tracer.back.elastic.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.amayas.tracer.back.elastic.repositories")
//@PropertySource(value = "application.properties")
public class ElasticSearchConfiguration {
	
//    @Value("${elasticsearch.host}")
//    private String EsHost;
//
//    @Value("${elasticsearch.port}")
//    private int EsPort;
//
//    @Value("${elasticsearch.clustername}")
//    private String EsClusterName;
//
//    @Bean
//    public Client client() throws Exception {
//
//        Settings esSettings = Settings.builder()
//                .put("cluster.name", EsClusterName).put("node.name", "node-1")
//                .build();
//        PreBuiltTransportClient preBuiltTransportClient = null;
//        TransportClient tc = null;
//        try {
//	        preBuiltTransportClient = new PreBuiltTransportClient(esSettings);
//	        tc = preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
//        } catch(Exception e) {
//        	e.printStackTrace();
//        } finally {
////        	if(preBuiltTransportClient != null)
////        		preBuiltTransportClient.close();
//        }
//        return tc; 
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }
	

}
