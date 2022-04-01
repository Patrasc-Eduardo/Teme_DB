package com.springpractice.demospring.services;

import com.springpractice.demospring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springpractice.demospring.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(orders::add);
        return orders;
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        orderRepository.save(order);
        return order;
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getAllOrdersByCustomId(Integer id) {
        return orderRepository.getAllOrdersByCustomerId(id);
    }
}
