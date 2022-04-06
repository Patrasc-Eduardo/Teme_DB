package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductDAO implements IDao<Product> {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> get(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }
    @Override
    public void create(Product toCreate) {
        productRepository.save(toCreate);
    }

    @Override
    public void delete(Product toDelete) {
        productRepository.delete(toDelete);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product toUpdate) {
        productRepository.save(toUpdate);
    }
}
