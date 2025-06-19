package com.course.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HelloKafkaConsumer {

    @KafkaListener(topics = "t-v2-test-topic")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }

}
