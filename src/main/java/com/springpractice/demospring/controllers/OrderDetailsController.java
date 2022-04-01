package com.springpractice.demospring.controllers;

import com.springpractice.demospring.model.Order;
import com.springpractice.demospring.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springpractice.demospring.services.OrderDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderDetailsController {
  @Autowired OrderDetailsService orderDetailsService;

  @GetMapping("/order-details")
  public List<OrderDetails> getAllOrdDetails() {
    return orderDetailsService.getAllOrderDetails();
  }

  @GetMapping("/order-details/{id}")
  public Optional<OrderDetails> getOrdDetailsById(@PathVariable Integer id) {
    return orderDetailsService.getById(id);
  }

  @PostMapping("/order-details")
  public OrderDetails createOrdDetails(@RequestBody OrderDetails orderDetails) {
    orderDetailsService.insert(orderDetails);
    return orderDetails;
  }

  @PostMapping("/order-details/update")
  public OrderDetails updateOrdDetails(@RequestBody OrderDetails orderDetails) {
    orderDetailsService.update(orderDetails);
    return orderDetails;
  }

  @GetMapping("/order-details/filter")
  public List<OrderDetails> getOrderDetailsByOrderId(@RequestParam("orderId") Integer orderId) {
    return orderDetailsService.getAllOrderDetails().stream()
        .filter(orderDetails -> orderDetails.getOrderId() == orderId)
        .collect(Collectors.toList());
  }
}
