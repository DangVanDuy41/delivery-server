package com.example.deliveryserver.service.storeProduct;


import com.example.deliveryserver.entity.StoreProducts;
import com.example.deliveryserver.repository.StoreProductRepository;
import com.example.deliveryserver.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class StoreProductImpl extends BaseService<StoreProducts,StoreProductRepository> implements StoreProductService{

    public StoreProductImpl(StoreProductRepository repo) {
        super(repo);
    }
}
