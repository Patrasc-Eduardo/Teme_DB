package com.springpractice.demospring.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderDate;
    private String shippedDate;
    private String status;
    private String comments;
}
