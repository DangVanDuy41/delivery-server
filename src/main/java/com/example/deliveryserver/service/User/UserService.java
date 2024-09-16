package com.example.deliveryserver.service.User;

import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.service.IBaseService;

import java.util.Optional;


public interface UserService extends IBaseService<User> {
        Optional<User> findByEmail(String username);
}
