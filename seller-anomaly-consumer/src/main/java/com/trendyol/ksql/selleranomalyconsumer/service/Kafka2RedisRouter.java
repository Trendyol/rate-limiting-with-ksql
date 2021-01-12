package com.trendyol.ksql.selleranomalyconsumer.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendyol.ksql.selleranomalyconsumer.config.KafkaProperties;
import com.trendyol.ksql.selleranomalyconsumer.model.BlockSellerMessage;
import com.trendyol.ksql.selleranomalyconsumer.model.BlockedSeller;
import com.trendyol.ksql.selleranomalyconsumer.repository.BlockedSellerRepository;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@EnableConfigurationProperties(KafkaProperties.class)
public class Kafka2RedisRouter extends RouteBuilder {

    private final BlockedSellerRepository blockedSellerRepository;
    private final KafkaProperties kafkaProperties;


    public Kafka2RedisRouter(BlockedSellerRepository blockedSellerRepository, KafkaProperties kafkaProperties) {
        this.blockedSellerRepository = blockedSellerRepository;
        this.kafkaProperties = kafkaProperties;
    }

    @Override
    public void configure() {
        from(kafkaProperties.getConsumerConfig())
                .log(
                        "Seller anomaly message received: ${body} "
                                + "on topic: ${headers[kafka.TOPIC]}, "
                                + "on partition: ${headers[kafka.PARTITION]}, "
                                + "with offset: ${headers[kafka.OFFSET]}, "
                                + "with key: ${headers[kafka.KEY]}")
                .filter(exchange -> Objects.nonNull(exchange.getMessage().getBody()))
                .process(
                        exchange -> {
                            String body = exchange.getIn().getBody(String.class);
                            BlockSellerMessage blockSellerMessage = new ObjectMapper().readValue(body, BlockSellerMessage.class);
                            BlockedSeller blockedSeller = new BlockedSeller(blockSellerMessage.getSellerId(), blockSellerMessage.getRequestCount());
                            blockedSellerRepository.save(blockedSeller);
                        })
                .log(
                        "Seller insert into blocked with message: ${body} "
                                + "on topic: ${headers[kafka.TOPIC]}, "
                                + "on partition: ${headers[kafka.PARTITION]}, "
                                + "with offset: ${headers[kafka.OFFSET]}, "
                                + "with key: ${headers[kafka.KEY]}");
    }

}
