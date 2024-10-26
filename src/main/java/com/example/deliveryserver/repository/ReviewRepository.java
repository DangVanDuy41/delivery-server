package com.example.deliveryserver.repository;


import com.example.deliveryserver.dto.ReviewDTO;
import com.example.deliveryserver.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {

    @Query("SELECT new com.example.deliveryserver.dto.ReviewDTO(r,u.fullName,u.avatar,u.id) FROM Review  r " +
            "JOIN User  u " +
            "ON u.id = r.userId " +
            "WHERE  r.storeId = ?1 AND r.productId = ?2"
    )
    List<ReviewDTO>  findByStoreIdAndProductId(UUID storeId, UUID productId);

}
