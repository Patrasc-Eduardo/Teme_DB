package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CustomerAuthDTO {
    private String username;
    private String email;
    private String password;

}
