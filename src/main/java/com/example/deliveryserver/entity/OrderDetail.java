package com.example.deliveryserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@Table(name = "order_details")
public class OrderDetail extends  BaseEntity{
    Integer quantity;
    Double price;
    Double total;
    UUID productId;
    UUID userId;
    UUID oderId;
}
