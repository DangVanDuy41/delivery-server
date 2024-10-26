package com.example.deliveryserver.service.review;

import com.example.deliveryserver.dto.ReviewDTO;
import com.example.deliveryserver.entity.Review;
import com.example.deliveryserver.service.IBaseService;

import java.util.List;
import java.util.UUID;

public interface ReviewService extends IBaseService<Review> {
    List<ReviewDTO> findByStoreIdAndProductId(UUID storeId, UUID productId);
}
