package com.example.deliveryserver.dto;

import com.example.deliveryserver.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ProductStoreDTO {
    UUID id;
    String name;
    String image;
    String description;
    UUID categoryId;
    Double price;
    Double rating;
    StoreOfProductDTO store ;
    List<ReviewDTO> reviews;

    public  ProductStoreDTO(Product product, Double price, Double rating, UUID storeId,String storeName){
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getName();
        this.categoryId= product.getCategoryId();
        this.description= product.getDescription();
        this.price = price;
        this.rating = rating;
        this.store = new StoreOfProductDTO(storeId,storeName);
    }
}
