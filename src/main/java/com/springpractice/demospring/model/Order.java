package com.springpractice.demospring.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CostumOrder")
public class Order {
  @Id @GeneratedValue @ReadOnlyProperty private Integer id;
  private String orderDate;
  private String shippedDate;
  private String status;
  private String comments;
  @Id @ReadOnlyProperty private Integer customerId;
  //    @ManyToOne
  //    Customer customer;

  public Order(
      Integer id,
      String orderDate,
      String shippedDate,
      String status,
      String comments,
      Integer customerId) {

    this.id = id;
    this.orderDate = orderDate;
    this.shippedDate = shippedDate;
    this.status = status;
    this.comments = comments;
    this.customerId = customerId;

  }
}
