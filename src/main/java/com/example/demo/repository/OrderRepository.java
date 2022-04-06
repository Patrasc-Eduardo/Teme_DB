package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
