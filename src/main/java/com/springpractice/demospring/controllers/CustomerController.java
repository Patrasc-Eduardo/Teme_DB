package com.springpractice.demospring.controllers;

import com.springpractice.demospring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springpractice.demospring.services.CustomerService;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
  @Autowired CustomerService customerService;

  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/customers/{id}")
  public Optional<Customer> getCustomerById(@PathVariable Integer id) {
    return customerService.getById(id);
  }

  @PutMapping("/customers")
  public Customer createCustomer(@RequestBody Customer customer) {
    customerService.insert(customer);
    return customer;
  }

  @PostMapping("/customers/update")
  public Customer updateCustomer(@RequestBody Customer customer) {
    return customerService.update(customer);
  }

  @DeleteMapping("/customers/delete/{id}")
  public void deleteCustomer(@PathVariable Integer id) {
    customerService.deletebyId(id);
  }
}
