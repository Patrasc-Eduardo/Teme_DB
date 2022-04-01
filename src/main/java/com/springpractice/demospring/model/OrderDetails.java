package com.springpractice.demospring.model;

import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;

@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer productCode;
    private Integer quantity;
    private Double priceEach;

    @ManyToOne
    @JoinColumn( name = "order_id")
    Order order;

}
