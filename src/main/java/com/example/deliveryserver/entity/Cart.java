package com.example.deliveryserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "carts")
public class Cart extends BaseEntity{
    Integer quantity;
    Double price;
    Double total;
    UUID userId;
    UUID productId;
}
