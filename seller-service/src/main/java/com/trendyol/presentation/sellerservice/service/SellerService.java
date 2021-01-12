package com.trendyol.presentation.sellerservice.service;

import com.trendyol.presentation.sellerservice.model.Order;
import com.trendyol.presentation.sellerservice.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public List<Order> getOrders(Long sellerId) {
        return sellerRepository.getOrders(sellerId);
    }
}
