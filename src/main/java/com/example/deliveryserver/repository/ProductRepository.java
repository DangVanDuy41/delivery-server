package com.example.deliveryserver.repository;

import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.dto.ProductStoreDTO;
import com.example.deliveryserver.entity.Product;
import com.example.deliveryserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.lang.annotation.Native;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT new com.example.deliveryserver.dto.ProductDTO(p,sp.price,sp.rating) from  Product  p " +
            "JOIN  StoreProducts sp " +
            "ON p.id = sp.productId " +
            "JOIN Store  s ON s.id = sp.storeId " +
            "WHERE s.user = ?1"
    )
    List<ProductDTO> getAllByStore(User user);

    @Query("""
            SELECT new com.example.deliveryserver.dto.ProductDTO(p,sp.price,sp.rating) from  Product  p \
            JOIN  StoreProducts sp \
            ON p.id = sp.productId \
            JOIN Store  s \
            ON s.id = sp.storeId \
            JOIN Category c \
            ON c.id = p.categoryId \
            WHERE s.user = ?1 AND c.id =?2"""
    )
    List<ProductDTO> getListProductByCategory(User user, UUID id);

    @Query("SELECT new com.example.deliveryserver.dto.ProductStoreDTO(p,sp.price,sp.rating,s.id,s.name) from  Product  p " +
            "JOIN  StoreProducts sp " +
            "ON p.id = sp.productId " +
            "JOIN Store  s ON s.id = sp.storeId " +
            "WHERE p.id =?1"
    )
    ProductStoreDTO getProductById(UUID id);
}
