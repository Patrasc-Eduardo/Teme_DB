package com.springpractice.demospring.model;

import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
  @Id @GeneratedValue private Integer id;
  private String username;
  private String last_name;
  private String first_name;
  private String phone;
  private String address;
  private String city;
  private String postal_code;
  private String country;
  
  @OneToMany
  private List<Order> orders;
}