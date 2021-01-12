package com.trendyol.presentation.sellerservice.aspect;


import com.trendyol.presentation.sellerservice.model.SellerRequestMessage;
import com.trendyol.presentation.sellerservice.producer.SellerRequestProducer;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class SellerRequestProducerAspect {

    private final SellerRequestProducer sellerRequestProducer;

    @Value("${spring.application.name}")
    private String projectName;

    public SellerRequestProducerAspect(SellerRequestProducer sellerRequestProducer) {
        this.sellerRequestProducer = sellerRequestProducer;
    }

    @After("execution(* com.trendyol.presentation.sellerservice.service.SellerService.getOrders(..)) && args(sellerId)")
    public void afterAdvice(Long sellerId) {
        SellerRequestMessage sellerRequestMessage = SellerRequestMessage
                .builder()
                .sellerId(sellerId)
                .ip("192.168.0.1")
                .agent("Mozilla/5.0")
                .appName(projectName)
                .requestTime(new Date())
                .requestType("/GET")
                .build();

        sellerRequestProducer.produce(sellerRequestMessage);
    }
}
