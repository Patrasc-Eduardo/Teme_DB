package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface IDao <T> {
    Optional<T> get(Integer id);
    void create(T toCreate);
    void delete(T toDelete);
    void update(T toUpdate);
}
