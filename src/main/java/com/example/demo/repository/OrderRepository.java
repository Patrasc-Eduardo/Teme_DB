package com.example.demo.repository;

import com.example.demo.dao.OrderDAO;
import com.example.demo.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<OrderDAO, UUID> {
}
