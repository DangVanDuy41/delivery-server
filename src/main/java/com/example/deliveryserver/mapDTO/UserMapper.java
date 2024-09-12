package com.example.deliveryserver.mapDTO;

import com.example.deliveryserver.DTO.UserDTO;
import com.example.deliveryserver.DTO.UserProfileDTO;
import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.entity.UserProfile;

public class UserMapper {

    public static UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build();

        if (user.getUserProfile() != null) {
            UserProfile userProfile = user.getUserProfile();
            UserProfileDTO userProfileDTO = UserProfileDTO.builder()
                    .address(userProfile.getAddress())
                    .phoneNumber(userProfile.getPhoneNumber())
                    .id(userProfile.getId())
                    .build();

            userDTO.setProfile(userProfileDTO);
        }
        return userDTO;
    }
}
