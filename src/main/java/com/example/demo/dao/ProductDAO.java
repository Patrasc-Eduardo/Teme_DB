package com.example.demo.dao;

import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductDAO implements IDao<ProductDAO> {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductDAO> get(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public void create(ProductDAO toCreate) {
        productRepository.save(toCreate);
    }

    @Override
    public void delete(ProductDAO toDelete) {
        productRepository.delete(toDelete);
    }

    @Override
    public void update(ProductDAO toUpdate) {
        productRepository.save(toUpdate);
    }
}
