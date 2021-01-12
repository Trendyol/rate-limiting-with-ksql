package com.trendyol.presentation.sellerservice.aspect;


import com.trendyol.presentation.sellerservice.exception.TooManyRequest;
import com.trendyol.presentation.sellerservice.repository.BlockedSellerRepository;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SellerAnomalyAspect {

    private final BlockedSellerRepository blockedSellerRepository;

    public SellerAnomalyAspect(BlockedSellerRepository blockedSellerRepository) {
        this.blockedSellerRepository = blockedSellerRepository;
    }

    @Before("execution(* com.trendyol.presentation.sellerservice.service.SellerService.getOrders(..)) && args(sellerId)")
    public void afterAdvice(Long sellerId) {
        if (blockedSellerRepository.existsById(sellerId)) {
            throw new TooManyRequest("Too many request");
        }
    }
}
