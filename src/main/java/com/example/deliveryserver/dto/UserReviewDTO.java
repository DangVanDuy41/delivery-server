package com.example.deliveryserver.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewDTO {
    private String name;
    private String avatar;
    private UUID id;
}
