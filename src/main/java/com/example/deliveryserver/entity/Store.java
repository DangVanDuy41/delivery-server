package com.example.deliveryserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "stores")
public class Store extends  BaseEntity{
    String name;
    String phoneNumber;
    String address;
    String description;
    Double rating;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
