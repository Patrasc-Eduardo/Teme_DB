package com.springpractice.demospring.services;

import com.springpractice.demospring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springpractice.demospring.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Optional<Customer> getById(Integer id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }

    public Customer insert(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public Customer update(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public void deletebyId(Integer id) {
        customerRepository.deleteById(id);
    }
}
