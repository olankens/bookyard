package com.bookyard.messaging;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookEventProducerTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private BookEventProducer bookEventProducer;

    @Test
    void sendBookCreatedEventPublishesToBookCreatedTopic() {
        bookEventProducer.sendBookCreatedEvent("Dune");
        verify(kafkaTemplate).send("book-created", "Dune");
    }
}
