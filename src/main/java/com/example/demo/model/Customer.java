package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@Table(name = "customers")
public class Customer implements Serializable {
  @Id @GeneratedValue private Integer customerId;
  private String username;
  private String city;
  private String country;
  private String postalCode;
  private String address;
  private String email;
  private String password;

  @OneToMany private List<Order> orders;

  public Customer(String username, String city, String country, String postalCode, String address) {
    this.username = username;
    this.city = city;
    this.country = country;
    this.postalCode = postalCode;
    this.address = address;
  }
}
