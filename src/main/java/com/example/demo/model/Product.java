package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@EnableAutoConfiguration
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Integer productId;
    private int productCode;
    private String productName;
    private String description;

    public Product(int productCode, String productName, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
    }
}
