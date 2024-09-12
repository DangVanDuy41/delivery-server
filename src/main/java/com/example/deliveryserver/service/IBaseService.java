package com.example.deliveryserver.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IBaseService<T>  {
    T saveOrUpdate(T entity);

    List<T> getList();



    Optional<T> getById(UUID id);

    void deleteById(UUID id);
}
