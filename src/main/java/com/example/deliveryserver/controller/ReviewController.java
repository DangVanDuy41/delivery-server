package com.example.deliveryserver.controller;


import com.example.deliveryserver.dto.ApiResponse;
import com.example.deliveryserver.dto.ReviewRequestDTO;
import com.example.deliveryserver.entity.Review;
import com.example.deliveryserver.enums.Status;
import com.example.deliveryserver.mapper.Mapper;
import com.example.deliveryserver.service.review.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController()
@RequestMapping("/api/reviews")
public class ReviewController {

    public final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/user/review-product")
    public ApiResponse<Boolean> reviewProduct(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        Review review = Mapper.reviewRequestDTOToReview(reviewRequestDTO);
        Boolean result = this.reviewService.saveOrUpdate(review) != null;
        return ApiResponse.<Boolean>builder()
                .data(result)
                .time(new Date())
                .message(String.valueOf(Status.SUCCESS))
                .build();
    }

}
