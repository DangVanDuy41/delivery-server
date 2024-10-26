package com.example.deliveryserver.dto;


import com.example.deliveryserver.entity.Review;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ReviewDTO {
    UUID id;
    Double rating;
    String comment;
    Date createdAt;
    UserReviewDTO user;

    public ReviewDTO(Review review, String userName, String userAvatar,UUID userId) {
        this.id = review.getId();
        this.comment = review.getComment();
        this.rating = review.getRating();
        this.user = new UserReviewDTO(userName, userAvatar,userId);
        this.createdAt = review.getCreatedAt();

    }
}
