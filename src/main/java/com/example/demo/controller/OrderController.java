package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
  @Autowired
  OrderService orderService;

  @GetMapping("/orders")
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/orders/{id}")
  public Optional<Order> getOrderById(@PathVariable Integer id) {
    return orderService.getById(id);
  }

  @PutMapping("/orders")
  public void createOrder(@RequestBody Order order) {
    orderService.createOrder(order);
  }

  @PostMapping("/orders/update")
  public void updateOrder(@RequestBody Order order) {
    orderService.update(order);
  }

  @DeleteMapping("/orders/delete/{id}")
  public void deleteOrderById(@PathVariable Integer id) {
    orderService.deleteById(id);
  }

  @PostMapping("/customers/update/{id}/{status}")
  public Optional<Order> updateOrder(@PathVariable Integer id, @PathVariable String status) {
    Optional<Order> newOrder = orderService.getById(id);
    newOrder.get().setDescription(status);
    return newOrder;
  }
}
