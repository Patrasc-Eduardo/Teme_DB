package com.example.demo.repository;

import com.example.demo.dao.ProductDAO;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductDAO, UUID> {
}
