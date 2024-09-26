package com.example.deliveryserver.service.product;

import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.entity.Product;
import com.example.deliveryserver.service.IBaseService;

import java.util.List;
import java.util.UUID;

public interface ProductService extends IBaseService<Product> {
    Product createProduct(Product entity,Double price);
    List<ProductDTO> getListByStore();
    List<ProductDTO> getListProductByCategory(UUID id);
}
