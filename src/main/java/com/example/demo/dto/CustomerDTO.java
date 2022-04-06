package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CustomerDTO {
    private String username;
    private String city;
    private String country;
    private String postalCode;
    private String address;
}
