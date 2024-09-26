package com.example.deliveryserver.entity;

import jakarta.persistence.Column;
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
@Table(name="products")
public class Product extends  BaseEntity{
    String name;
    @Column(columnDefinition = "TEXT")
     String image;
    String description;
    UUID categoryId;
}
