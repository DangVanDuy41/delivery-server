package com.example.deliveryserver.entity;

import com.example.deliveryserver.enums.Role;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "users")
public class User extends  BaseEntity {
    String fullName;
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    Role role;
    @OneToOne(mappedBy = "user")
    UserProfile userProfile;
    @OneToOne(mappedBy = "user")
    Store store;
}
