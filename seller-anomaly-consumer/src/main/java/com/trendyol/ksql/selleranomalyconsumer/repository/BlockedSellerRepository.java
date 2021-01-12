package com.trendyol.ksql.selleranomalyconsumer.repository;

import com.trendyol.ksql.selleranomalyconsumer.model.BlockedSeller;
import org.springframework.data.repository.CrudRepository;

public interface BlockedSellerRepository extends CrudRepository<BlockedSeller, Long> {
}
