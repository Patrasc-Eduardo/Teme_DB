package com.springpractice.demospring.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer productCode;
    private Integer quantity;
    private Double priceEach;

    @Id
    @ReadOnlyProperty
    private Integer orderId;

    public OrderDetails(Integer id, Integer productCode, Integer quantity, Double priceEach, Integer orderId) {
        this.id = id;
        this.productCode = productCode;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }
}
