package com.example.deliveryserver.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Getter
@Setter
public class StoreProducts extends BaseEntity{
    Double rating;
    UUID  productId;
    UUID  storeId;
    Double price;
}
