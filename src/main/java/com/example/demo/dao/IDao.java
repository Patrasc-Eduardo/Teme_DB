package com.example.demo.dao;

import java.util.Optional;
import java.util.UUID;

public interface IDao <T> {
    Optional<T> get(UUID id);
    void create(T toCreate);
    void delete(T toDelete);
    void update(T toUpdate);
}
