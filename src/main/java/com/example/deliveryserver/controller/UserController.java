package com.example.deliveryserver.controller;

import com.example.deliveryserver.DTO.ApiResponse;
import com.example.deliveryserver.DTO.UserDTO;
import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.mapDTO.UserMapper;
import com.example.deliveryserver.service.User.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<?> listUser() {
        List<User> userList = userService.getList();
        List<UserDTO> userDTOS = userList.stream()
                .map(UserMapper::userToUserDTO)
                .collect(Collectors.toList());

        return ApiResponse.<List<UserDTO>>builder()
                .time(new Date())
                .message("success")
                .data(userDTOS)
                .build();
    }
}
