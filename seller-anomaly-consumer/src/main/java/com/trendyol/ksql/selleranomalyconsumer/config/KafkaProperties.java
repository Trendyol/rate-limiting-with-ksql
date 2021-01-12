package com.trendyol.ksql.selleranomalyconsumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties(prefix = "camel.kafka")
public class KafkaProperties {

    private static String PREFIX = "kafka";
    private static String DELIMETER = ":";

    private List<String> consumerTopics;
    private String producerTopic;
    private List<String> brokers = new ArrayList<>();
    private String groupId;

    public String getProducerTopic() {
        return producerTopic;
    }

    public void setProducerTopic(String producerTopic) {
        this.producerTopic = producerTopic;
    }

    public List<String> getBrokers() {
        return brokers;
    }

    public void setBrokers(List<String> brokers) {
        this.brokers = brokers;
    }

    public List<String> getConsumerTopics() {
        return consumerTopics;
    }

    public void setConsumerTopics(List<String> consumerTopics) {
        this.consumerTopics = consumerTopics;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getConsumerConfig() {
        return new StringBuilder()
                .append(PREFIX)
                .append(DELIMETER)
                .append(getConsumerTopics().stream().collect(Collectors.joining(",")))
                .append("?")
                .append("brokers=" + getBrokers().stream().collect(Collectors.joining(",")))
                .append("&")
                .append("groupId=" + getGroupId())
                .toString();
    }

}
