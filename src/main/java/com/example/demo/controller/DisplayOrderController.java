package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DisplayOrderController {
  @Autowired OrderService orderService;

  @GetMapping("/view-orders")
  public ModelAndView displayOrders() {
    List<Order> orders = new ArrayList<>();
    orderService.getAllOrders().iterator().forEachRemaining(orders::add);

    ModelAndView modelAndView = new ModelAndView("viewOrders");
    modelAndView.addObject("orders", orders);
    return modelAndView;
  }
}
