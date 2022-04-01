package com.springpractice.demospring.model;

import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CostumOrder")
@ToString
public class Order {
  @Id @GeneratedValue private Integer id;
  private String orderDate;
  private String shippedDate;
  private String status;
  private String comments;

  @JoinColumn( name = "customer_id")
  @ManyToOne
  Customer customer;


}
