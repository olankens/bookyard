package com.bookyard.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public BookEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBookCreatedEvent(String message) {
        kafkaTemplate.send("book-created", message);
    }
}