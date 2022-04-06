package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/customers/{id}")
  public Optional<Customer> getCustomerById(@PathVariable Integer id) {
    return customerService.get(id);
  }

  @PutMapping("/customers")
  public void createCustomer(@RequestBody CustomerDTO customer) {
    customerService.create(
        new Customer(
            customer.getUsername(),
            customer.getCity(),
            customer.getCountry(),
            customer.getPostalCode(),
            customer.getAddress()));
  }

  @PostMapping("/customers/update")
  public void updateCustomer(@RequestBody Customer customer) {
    customerService.update(customer);
  }

  @DeleteMapping("/customers/delete/{id}")
  public void deleteCustomer(@PathVariable Integer id) {
    customerService.deleteById(id);
  }
}
