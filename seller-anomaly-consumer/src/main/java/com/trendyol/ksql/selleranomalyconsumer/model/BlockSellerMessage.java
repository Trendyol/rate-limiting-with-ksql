package com.trendyol.ksql.selleranomalyconsumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BlockSellerMessage implements Serializable {

    private static final long serialVersionUID = 5867018081694474440L;

    @JsonProperty("SELLER_ID")
    private Long sellerId;

    @JsonProperty("REQUEST_COUNT")
    private Long requestCount;

    public BlockSellerMessage() {
    }

    public BlockSellerMessage(Long sellerId, Long requestCount) {
        this.sellerId = sellerId;
        this.requestCount = requestCount;
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
        return new ToStringBuilder(this)
                .append("sellerId", sellerId)
                .append("requestCount", requestCount)
                .toString();
    }
}
