package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DisplayCustomerController {
  @Autowired CustomerService customerService;

  @GetMapping("/view-customers")
  public ModelAndView displayCostumers() {
    List<Customer> customers = new ArrayList<>();
    customerService.getAllCustomers().iterator().forEachRemaining(customers::add);

    ModelAndView modelAndView = new ModelAndView("viewCustomers");
    modelAndView.addObject("customers", customers);
    return modelAndView;
  }


  @GetMapping("/view-customers/{id}")
  public ModelAndView filterCustomerById(@PathVariable Integer id) {
    Optional<Customer> customerById = customerService.get(id);
    ModelAndView modelAndView = new ModelAndView("viewCustomerById");
    modelAndView.addObject("customerById", customerById.get());
    return modelAndView;
  }

  @GetMapping("/view-customers/username/{username}")
  public ModelAndView filterCustomerByUsername(@PathVariable String username) {
    Optional<Customer> customerByUsername= customerService.getByUsername(username);
    ModelAndView modelAndView = new ModelAndView("viewCustomerByUsername");
    modelAndView.addObject("customerByUsername", customerByUsername.get());
    return modelAndView;
  }

  @GetMapping("/view-customers/city/{city}")
  public ModelAndView filterCustomerByCity(@PathVariable String city) {
    List<Customer> customersByCity= customerService.getByCity(city);
    ModelAndView modelAndView = new ModelAndView("viewCustomersByCity");
    modelAndView.addObject("customersByCity", customersByCity);
    return modelAndView;
  }

  @GetMapping("/view-customers/country/{country}")
  public ModelAndView filterCustomerByCountry(@PathVariable String country) {
    List<Customer> customersByCountry = customerService.getByCountry(country);
    ModelAndView modelAndView = new ModelAndView("viewCustomersByCountry");
    modelAndView.addObject("customersByCountry", customersByCountry);
    return modelAndView;
  }
}
