package com.trendyol.presentation.sellerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequestMessage {

    private UUID id = UUID.randomUUID();
    private Long sellerId;
    private String ip;
    private String agent;
    private String appName;
    private String requestType;
    private Date requestTime;

}
