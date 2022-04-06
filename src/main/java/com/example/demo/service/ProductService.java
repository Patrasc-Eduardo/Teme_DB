package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
  @Autowired ProductDAO productDAO;

  public Optional<Product> get(Integer id) {
    return productDAO.get(id);
  }

  public List<Product> getAllProducts() {
    return productDAO.getAllProducts();
  }

  public void create(Product toCreate) {
    productDAO.create(toCreate);
  }

  public void delete(Product toDelete) {
    productDAO.delete(toDelete);
  }

  public void deleteById(Integer id) {
    productDAO.deleteById(id);
  }

  public void update(Product toUpdate) {
    productDAO.update(toUpdate);
  }
}
