package com.example.deliveryserver.repository;

import com.example.deliveryserver.entity.Store;
import com.example.deliveryserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {

    Store findByUser(User user);
}
