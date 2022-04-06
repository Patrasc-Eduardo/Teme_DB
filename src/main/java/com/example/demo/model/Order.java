package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class Order {
    private UUID orderId;
    private String description;
    private long orderDate;
    private long shippedDate;
}
