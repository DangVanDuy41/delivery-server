package com.example.deliveryserver.mapper;


import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.entity.Product;

import java.util.Date;


public class ProductMapper {

    public static Product productDTOToProduct(ProductDTO productDTO){
            return Product.builder()
                    .image(productDTO.getImage())
                    .name(productDTO.getName())
                    .description(productDTO.getDescription())
                    .categoryId(productDTO.getCategoryId())
                    .createdAt(new Date())
                    .build();
    }

}
