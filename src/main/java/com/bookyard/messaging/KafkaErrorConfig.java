package com.bookyard.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaErrorConfig {

    @Bean
    public DefaultErrorHandler errorHandler(KafkaTemplate<String, String> kafkaTemplate) {
        var recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate);
        var backOff = new FixedBackOff(1000L, 3);
        return new DefaultErrorHandler(recoverer, backOff);
    }
}