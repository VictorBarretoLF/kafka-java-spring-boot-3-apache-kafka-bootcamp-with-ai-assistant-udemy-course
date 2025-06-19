package com.course.kafka.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        name = "app.kafka.producer.HelloKafkaProducer.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class HelloKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        String randomName = "User" + UUID.randomUUID().toString().substring(0, 8);
        try {
            kafkaTemplate.send("t-v2-test-topic", "Hello " + randomName).get();
            System.out.println("Sent message: Hello " + randomName);
        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

}
