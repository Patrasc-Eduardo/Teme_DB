package com.springpractice.demospring.repositories;

import com.springpractice.demospring.model.Order;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    public List<Order> getAllOrdersByCustomerId(Integer id);
}
