package com.trendyol.presentation.sellerservice.producer;

import com.trendyol.presentation.sellerservice.model.SellerRequestMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerRequestProducer {

    private static final Logger log = LoggerFactory.getLogger(SellerRequestProducer.class);

    private final String topicName = "demo.seller-core.seller-request";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void produce(SellerRequestMessage sellerRequestMessage) {
        kafkaTemplate.send(topicName, sellerRequestMessage);
        log.info("Seller request event produced for {}", sellerRequestMessage.getSellerId());
    }
}
