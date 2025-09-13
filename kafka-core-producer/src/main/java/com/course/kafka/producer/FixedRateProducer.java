package com.course.kafka.producer;

import com.course.kafka.enums.KafkaTopics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@ConditionalOnProperty(
        name = "app.kafka.producer.FixedRateProducer.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class FixedRateProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        i++;
        log.info("Sending the number {}", i);
        kafkaTemplate.send(KafkaTopics.Constants.TOPIC_FIXED_RATE_NAME, "Fixed rate " + i);
    }

}
