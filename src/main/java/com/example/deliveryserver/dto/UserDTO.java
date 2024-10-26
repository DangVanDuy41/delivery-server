package com.example.deliveryserver.dto;


import com.example.deliveryserver.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserDTO {
    UUID id;
    String fullName;
    String email;
    String password;
    Date createdAt ;
    Role role;
    UserProfileDTO profile;
}
