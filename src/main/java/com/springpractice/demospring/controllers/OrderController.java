package com.springpractice.demospring.controllers;

import com.springpractice.demospring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springpractice.demospring.services.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController {
  @Autowired OrderService orderService;

  @GetMapping("/orders")
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/orders/{id}")
  public Optional<Order> getOrderById(@PathVariable Integer id) {
    return orderService.getById(id);
  }

  @PutMapping("/orders")
  public Order createOrder(@RequestBody Order order) {
    System.out.println(order.toString());
    Order order2 = orderService.insert(order);
    System.out.println(order2.toString());
    return order2;
  }

  @PostMapping("/orders/update")
  public Order updateOrder(@RequestBody Order order) {
    orderService.update(order);
    return order;
  }

  @DeleteMapping("/orders/delete/{id}")
  public void deleteOrderById(@PathVariable Integer id) {
    orderService.deleteById(id);
  }

  @PostMapping("/customers/update/{id}/{status}")
  public Order updateOrder(@PathVariable Integer id, @PathVariable String status) {
    Optional<Order> newOrder = orderService.getById(id);
    newOrder.get().setStatus(status);
    return orderService.update(newOrder.get());
  }

  @GetMapping("/orders/filter")
  public List<Order> getOrdersByCostumerId(@RequestParam("customerId") Integer customerId) {
    return orderService.getAllOrdersByCustomId(customerId);
  }
}
