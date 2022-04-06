package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class Customer {
    private UUID costumerId;
    private String username;
    private String city;
    private String country;
    private String postalCode;
    private String address;
}
