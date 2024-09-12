package com.example.deliveryserver.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public abstract class BaseService<T, R extends JpaRepository<T,UUID>> implements  IBaseService<T>{
    protected  R repo;

    public BaseService(R repo) {
        this.repo = repo;
    }

    @Override
    public T saveOrUpdate(T entity) {
        return repo.save(entity);
    }

    @Override
    public List<T> getList() {
        return repo.findAll();
    }

    @Override
    public Optional<T> getById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
