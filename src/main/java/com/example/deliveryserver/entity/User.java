package com.example.deliveryserver.entity;

import com.example.deliveryserver.enums.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import java.util.UUID;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String fullName;
    String email;
    String password;
    @CreatedDate
    @Column(updatable = false)
    Date createdAt = new Date();
    Role role;
    @OneToOne(mappedBy = "user")
    UserProfile userProfile;
}
