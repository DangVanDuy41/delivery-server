package com.example.deliveryserver.service.User;

import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.repository.UserRepository;
import com.example.deliveryserver.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseService<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repo) {
        super(repo);
    }

    @Override
    public User saveOrUpdate(User user) {
        User useExisting = repo.findByEmail(user.getEmail()).orElse(null);
        if(useExisting != null){
           throw  new RuntimeException("Email da ton tai");
        }
        return repo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String username) {
        return repo.findByEmail(username);
    }


}
