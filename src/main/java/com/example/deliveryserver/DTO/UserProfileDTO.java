package com.example.deliveryserver.DTO;

import com.example.deliveryserver.entity.User;
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
