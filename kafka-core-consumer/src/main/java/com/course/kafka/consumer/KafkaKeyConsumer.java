package com.course.kafka.consumer;

import com.course.kafka.enums.KafkaTopics;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaKeyConsumer {
    @KafkaListener(
            topics = KafkaTopics.Constants.T_MULTI_PARTITIONS,
            groupId = "kafka-key-consumer-group",
            concurrency = "3"
    )
    public void listen(ConsumerRecord<String, String> record) {
        log.info("Received message: Key={}, Value={}, Partition={}", record.key(), record.value(), record.partition());
    }
}
