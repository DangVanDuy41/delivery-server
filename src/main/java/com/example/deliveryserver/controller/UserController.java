package com.example.deliveryserver.controller;

import com.example.deliveryserver.dto.ApiResponse;
import com.example.deliveryserver.dto.UserDTO;
import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.mapper.UserMapper;
import com.example.deliveryserver.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> listUser() {
        List<User> userList = userService.getList();
        List<UserDTO> userDTOS = userList.stream()
                .map(UserMapper::userToUserDTO)
                .toList();

        return ApiResponse.<List<UserDTO>>builder()
                .time(new Date())
                .message("success")
                .data(userDTOS)
                .build();
    }
}
