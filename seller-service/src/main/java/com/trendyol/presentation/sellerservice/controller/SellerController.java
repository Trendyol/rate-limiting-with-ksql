package com.trendyol.presentation.sellerservice.controller;

import com.trendyol.presentation.sellerservice.model.Order;
import com.trendyol.presentation.sellerservice.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/{sellerId}/orders")
    public List<Order> getSellersOrders(@PathVariable("sellerId") Long sellerId) {
        return sellerService.getOrders(sellerId);
    }
}
