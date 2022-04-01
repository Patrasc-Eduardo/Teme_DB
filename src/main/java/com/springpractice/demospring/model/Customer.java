package com.springpractice.demospring.model;

import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Customer {
  @Id @GeneratedValue @ReadOnlyProperty private Integer id;
  private String username;
  private String last_name;
  private String first_name;
  private String phone;
  private String address;
  private String city;
  private String postal_code;
  private String country;

  //@OneToMany private List<Order> orders;

  public Customer(
      Integer id,
      String username,
      String last_name,
      String first_name,
      String phone,
      String address,
      String city,
      String postal_code,
      String country
      ) {
    this.id = id;
    this.username = username;
    this.last_name = last_name;
    this.first_name = first_name;
    this.phone = phone;
    this.address = address;
    this.city = city;
    this.postal_code = postal_code;
    this.country = country;

  }

  public Customer(
      String username,
      String last_name,
      String first_name,
      String phone,
      String address,
      String city,
      String postal_code,
      String country,
      List<Order> orders) {
    this.username = username;
    this.last_name = last_name;
    this.first_name = first_name;
    this.phone = phone;
    this.address = address;
    this.city = city;
    this.postal_code = postal_code;
    this.country = country;
    //this.orders = orders;
  }
}
