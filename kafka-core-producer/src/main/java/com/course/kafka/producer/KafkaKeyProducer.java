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
        name = "app.kafka.producer.KafkaKeyProducer.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class KafkaKeyProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int value = 0;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        value++;
        String key = java.util.UUID.randomUUID().toString();
        kafkaTemplate.send(KafkaTopics.Constants.T_MULTI_PARTITIONS, key, "Message " + value);
        log.info("Sent message: Key={}, Value={}", key, value);
    }

}
