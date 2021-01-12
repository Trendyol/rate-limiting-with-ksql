package com.trendyol.presentation.sellerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long sellerId;
    private String name;
    private Product product;
    private Address shipmentAddress;

}
