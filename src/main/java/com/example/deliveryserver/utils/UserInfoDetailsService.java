package com.example.deliveryserver.utils;

import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.repository.UserRepository;
import com.example.deliveryserver.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    public UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userService.findByEmail(username);
        return new UserInfoDetails(user.orElseThrow(() -> new UsernameNotFoundException("Username not found")));
    }
}
