package com.trendyol.presentation.sellerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "BlockedSeller")
public class BlockedSeller implements Serializable {

    private static final long serialVersionUID = 8203859342801531650L;

    @Id
    private Long sellerId;
    private Long requestCount;

    public BlockedSeller(Long sellerId, Long requestCount) {
        this.sellerId = sellerId;
        this.requestCount = requestCount;
    }

    public BlockedSeller() {
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    @Override
    public String toString() {
        return "BlockedSeller{" +
                "sellerId=" + sellerId +
                ", requestCount=" + requestCount +
                '}';
    }
}
