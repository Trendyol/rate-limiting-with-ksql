package com.trendyol.presentation.sellerservice.repository;

import com.trendyol.presentation.sellerservice.model.Address;
import com.trendyol.presentation.sellerservice.model.Order;
import com.trendyol.presentation.sellerservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SellerRepository {


    public List<Order> getOrders(Long sellerId) {
        Product productLG = Product
                .builder()
                .brandName("LG")
                .name("LG 55 TV")
                .build();
        Address shipmentAddress = Address
                .builder()
                .city("Ankara")
                .line("Susuz mah. 5000 cd. 22/220")
                .build();
        Order order1 = Order
                .builder()
                .sellerId(sellerId)
                .name("Ahmet")
                .product(productLG)
                .shipmentAddress(shipmentAddress)
                .build();

        return Arrays.asList(order1);
    }
}
