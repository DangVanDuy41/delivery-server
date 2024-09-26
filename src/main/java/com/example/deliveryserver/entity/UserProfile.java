package com.example.deliveryserver.entity;

import com.example.deliveryserver.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;



@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserProfile  extends BaseEntity{
    String phoneNumber;
    String address;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    Gender gender;
}
