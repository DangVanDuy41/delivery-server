package com.example.deliveryserver.entity;

import com.example.deliveryserver.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Getter
@Setter
@Table(name = "deliveries")
public class Delivery extends BaseEntity{
  String pickupLocation;
  String dropoutLocation;
  Status status;
  Date estimatedTime;
  Date actualTime;
  UUID orderId;
  UUID userId;
}
