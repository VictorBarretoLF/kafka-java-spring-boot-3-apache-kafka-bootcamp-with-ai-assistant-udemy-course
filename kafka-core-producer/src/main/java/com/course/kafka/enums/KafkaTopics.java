package com.course.kafka.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KafkaTopics {
    ;

    public static class Constants {
        public static final String DLT_SUFFIX = "-dlt";

        public static final String T_V2_TEST_TOPIC_NAME = "t-v2-test-topic";
        public static final String TOPIC_FIXED_RATE_NAME = "topic-fixed-rate";
        public static final String T_MULTI_PARTITIONS = "t-multi-partitions";
    }

}