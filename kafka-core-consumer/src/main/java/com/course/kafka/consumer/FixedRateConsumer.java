package com.course.kafka.consumer;

import com.course.kafka.enums.KafkaTopics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FixedRateConsumer {

    @KafkaListener(topics = KafkaTopics.Constants.TOPIC_FIXED_RATE_NAME)
    public void consume(String message) {
        log.info("Received message: {}", message);
    }

}
