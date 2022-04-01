package com.springpractice.demospring.dto;

import lombok.Data;

@Data
public class OrderDetailsDTO {
    private Integer productCode;
    private Integer quantity;
    private Double priceEach;
}
