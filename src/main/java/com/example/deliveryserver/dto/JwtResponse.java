package com.example.deliveryserver.dto;

import com.example.deliveryserver.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtResponse {
    String accessToken;
    Role role;
    String message;
    UUID userID;
}
