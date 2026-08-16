package com.bookyard.messaging;

import org.springframework.kafka.annotation.KafkaListener;

public class BookEventConsumer {

    @KafkaListener(topics = "book-created", groupId = "bookyard-group")
    public void consume(String message) {
        System.out.println("New book created: " + message);
    }
}