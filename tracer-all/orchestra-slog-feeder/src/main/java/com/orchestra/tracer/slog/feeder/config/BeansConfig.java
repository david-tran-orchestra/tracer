package com.orchestra.tracer.slog.feeder.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.net.ssl.SSLException;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.reactive.function.client.WebClient;

import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.slog.feeder.actions.SLogsSender;
import com.orchestra.tracer.slog.feeder.utils.ApplicationContextAccessor;

@Configuration
public class BeansConfig {
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("TracerLookup-");
        executor.initialize();
        return executor;
    }
	
	@Value("${web.client.url}")
    private String webClientUrl;

    @Bean
    public WebClient dbClient() throws SSLException {
    	SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
//        WebClient wc = WebClient.create(webClientUrl);
        ClientHttpConnector httpConnector = new ReactorClientHttpConnector(opt -> opt.sslContext(sslContext));
        WebClient wc = WebClient.builder().clientConnector(httpConnector).baseUrl(webClientUrl).build();
        return wc;
    }
    
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;
    
    @Value("${kafka.group.id}")
    private String groupId;
    
    @Bean
    public Map<String, Object> producerConfigs() {
      Map<String, Object> props = new HashMap<>();
      // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
      props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
      
      return props;
    }

    @Bean
    public ProducerFactory<String, InsertLogRequest> sLogsProducerFactory() {
      return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, InsertLogRequest> sLogsKafkaTemplate() {
      return new KafkaTemplate<>(sLogsProducerFactory());
    }

    @Bean
    public SLogsSender sender() {
      return new SLogsSender();
    }
    
    /*
     * Allows to access application context
     * for objects who are not part of it
     * */
    @Bean
    public ApplicationContextAccessor applicationContextAccessor() {
    	ApplicationContextAccessor accessor = new ApplicationContextAccessor();
    	accessor.setApplicationContext(context);
    	return accessor;
    }

}
