package com.springpractice.demospring.repositories;

import com.springpractice.demospring.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
