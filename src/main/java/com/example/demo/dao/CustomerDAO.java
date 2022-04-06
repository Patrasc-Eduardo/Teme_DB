package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerDAO implements IDao<Customer> {

  private final CustomerRepository customerRepository;

  @Override
  public Optional<Customer> get(Integer id) {
    return customerRepository.findById(id);
  }

  public Optional<Customer> getByUsername(String username) {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().iterator().forEachRemaining(customers::add);

    return customers.stream()
        .filter(customer -> (customer.getUsername().compareTo(username) == 0))
        .findFirst();
  }

  public List<Customer> getByCity(String city) {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().iterator().forEachRemaining(customers::add);

    return customers.stream()
        .filter(customer -> (customer.getCity().compareTo(city) == 0)).collect(Collectors.toList());
  }

  public List<Customer> getByCountry(String country) {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().iterator().forEachRemaining(customers::add);

    return customers.stream()
            .filter(customer -> (customer.getCountry().compareTo(country) == 0)).collect(Collectors.toList());
  }

  public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().iterator().forEachRemaining(customers::add);
    return customers;
  }

  @Override
  public void create(Customer toCreate) {
    customerRepository.save(toCreate);
  }

  @Override
  public void delete(Customer toDelete) {
    customerRepository.delete(toDelete);
  }

  public void deleteById(Integer id) {
    customerRepository.deleteById(id);
  }

  @Override
  public void update(Customer toUpdate) {
    customerRepository.save(toUpdate);
  }
}
