package com.example.deliveryserver.repository;
import com.example.deliveryserver.entity.StoreProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreProductRepository extends JpaRepository<StoreProducts, UUID> {

}
