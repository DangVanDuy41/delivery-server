package com.example.deliveryserver.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    Double rating;
    String comment;
    UUID userId;
    UUID productId;
    UUID storeId;
}
