package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OrderDTO {
    private String description;
    private String orderDate;
    private String shippedDate;
}
