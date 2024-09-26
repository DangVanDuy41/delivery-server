package com.example.deliveryserver.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDTO {
    UUID id;
    String phoneNumber;
    String address;


}
