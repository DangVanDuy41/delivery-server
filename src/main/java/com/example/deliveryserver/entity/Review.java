package com.example.deliveryserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name ="reviews")
public class Review  extends BaseEntity{
    Double rating;
    String comment;
    UUID storeId;
    UUID productId;
    UUID shipperId;
    UUID userId;
}
