package com.example.deliveryserver.service.User;

import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.repository.UserRepository;
import com.example.deliveryserver.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repo) {
        super(repo);
    }

}
