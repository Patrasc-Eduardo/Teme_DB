package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@Table(name = "custom_orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Integer orderId;
    private String description;
    private String orderDate;
    private String shippedDate;

    @JoinColumn( name = "customer_id")
    @ManyToOne
    Customer customer;

    public Order(String description, String orderDate, String shippedDate) {
        this.description = description;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
    }
}
