package com.springpractice.demospring.dto;

import com.springpractice.demospring.model.Order;
import lombok.Data;
import java.util.List;

@Data
public class CustomerDTO {
    private String username;
    private String last_name;
    private String first_name;
    private String phone;
    private String address;
    private String city;
    private String postal_code;
    private String country;
    private List<Order> orders;
}
