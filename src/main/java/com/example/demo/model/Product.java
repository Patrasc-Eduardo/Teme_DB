package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class Product {
    private UUID productId;
    private int productCode;
    private String productName;
    private String description;
}
