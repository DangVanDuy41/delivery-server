package com.example.deliveryserver.mapper;

import com.example.deliveryserver.dto.ReviewRequestDTO;
import com.example.deliveryserver.entity.Review;


import java.util.Date;


public class Mapper {

    private Mapper() {

    }
    public static Review reviewRequestDTOToReview(ReviewRequestDTO reviewRequestDTO) {
            return Review.builder()
                    .storeId(reviewRequestDTO.getStoreId())
                    .comment(reviewRequestDTO.getComment())
                    .productId(reviewRequestDTO.getProductId())
                    .userId(reviewRequestDTO.getUserId())
                    .rating(reviewRequestDTO.getRating())
                    .createdAt(new Date())
                    .build();
    }

}
