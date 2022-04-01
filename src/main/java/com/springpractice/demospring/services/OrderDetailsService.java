package com.springpractice.demospring.services;

import com.springpractice.demospring.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springpractice.demospring.repositories.OrderDetailsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public Optional<OrderDetails> getById(Integer id) {
        return orderDetailsRepository.findById(id);
    }

    public List<OrderDetails> getAllOrderDetails() {
        List<OrderDetails> orderDetails = new ArrayList<>();
        orderDetailsRepository.findAll().iterator().forEachRemaining(orderDetails::add);
        return orderDetails;
    }

    public void insert(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }

    public void update(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }

    public void delete(OrderDetails orderDetails) {
        orderDetailsRepository.delete(orderDetails);
    }

    public List<OrderDetails> getAllOrderDetailsByOrderId(Integer id) {
        return orderDetailsRepository.getAllOrderDetailsByOrderId(id);
    }
}
