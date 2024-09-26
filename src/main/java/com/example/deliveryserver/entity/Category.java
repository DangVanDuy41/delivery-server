package com.example.deliveryserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Getter
@Setter
@Table(name = "categories")
public class Category extends BaseEntity{
    String name;
}
