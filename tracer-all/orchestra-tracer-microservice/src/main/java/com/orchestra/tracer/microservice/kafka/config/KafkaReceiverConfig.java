package com.orchestra.tracer.microservice.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.microservice.kafka.client.KafkaReceiver;

@Configuration
@EnableKafka
public class KafkaReceiverConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.group.id}")
    private String groupId;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        JsonDeserializer<InsertLogRequest> des = new JsonDeserializer<>(InsertLogRequest.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // allows a pool of processes to divide the work of consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // TODO : what is group.id ??? how to configure it
        return props;
    }

    @Bean
    public ConsumerFactory<String, InsertLogRequest> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(InsertLogRequest.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, InsertLogRequest>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, InsertLogRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public KafkaReceiver receiver() {
        return new KafkaReceiver();
    }


}
