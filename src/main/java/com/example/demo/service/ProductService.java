package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired private ProductRepository productRepository;

  public Optional<Product> get(Integer id) {return productRepository.findById(id);}

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public void createProduct(Product toCreate) {
    productRepository.save(toCreate);
  }

  public void delete(Product toDelete) {
    productRepository.delete(toDelete);
  }

  public void deleteById(Integer id) {
    productRepository.deleteById(id);
  }

  public void update(Product toUpdate) {
    productRepository.save(toUpdate);
  }
}
