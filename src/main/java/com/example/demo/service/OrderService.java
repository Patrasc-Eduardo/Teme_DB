package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired private OrderRepository orderRepository;

    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(Order toCreate) {
        orderRepository.save(toCreate);
    }

    public void delete(Order toDelete) {
        orderRepository.delete(toDelete);
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    public void update(Order toUpdate) {
        orderRepository.save(toUpdate);
    }
}
