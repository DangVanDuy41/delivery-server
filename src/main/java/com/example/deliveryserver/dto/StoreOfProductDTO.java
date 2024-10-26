package com.example.deliveryserver.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class StoreOfProductDTO {
    UUID id;
    String name;

    public StoreOfProductDTO(UUID id, String name) {
        this.id = id;
        this.name = name;

    }
}
