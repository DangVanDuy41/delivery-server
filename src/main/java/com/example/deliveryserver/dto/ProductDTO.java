package com.example.deliveryserver.dto;

import com.example.deliveryserver.entity.Product;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    UUID id;
    String name;
    String image;
    String description;
    UUID categoryId;
    Double price;
    Double rating;

    public ProductDTO(Product product, Double price, Double rating){
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getName();
        this.categoryId= product.getCategoryId();
        this.description= product.getDescription();
        this.price = price;
        this.rating = rating;
    }
}
