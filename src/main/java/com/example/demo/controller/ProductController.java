package com.example.demo.controller;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {
  @Autowired
  ProductService productService;

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/products/{id}")
  public Optional<Product> getProductById(@PathVariable Integer id) {
    return productService.get(id);
  }

  @PutMapping("/products")
  public void createProduct(@RequestBody ProductDTO product) {
    productService.create(
        new Product(product.getProductCode(), product.getProductName(), product.getDescription()));
  }

  @PostMapping("/products/update")
  public void updateProduct(@RequestBody Product product) {
    productService.update(product);
  }

  @DeleteMapping("/products/delete")
  public void deleteOrder(@RequestBody Product toDelete) {
    productService.delete(toDelete);
  }

  @DeleteMapping("/products/delete/{id}")
  public void deleteOrderById(@PathVariable Integer id) {
    productService.deleteById(id);
  }
}
