package com.bookyard.messaging;

import lombok.Data;

@Data
public class BookEvent {
    private String title;
    private String author;
    private String eventType;
}