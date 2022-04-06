package com.example.demo.dao;

import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class CustomerDAO implements IDao<CustomerDAO> {

  private final CustomerRepository customerRepository;

  @Override
  public Optional<CustomerDAO> get(UUID id) {
    return customerRepository.findById(id);
  }

  @Override
  public void create(CustomerDAO toCreate) {
    customerRepository.save(toCreate);
  }

  @Override
  public void delete(CustomerDAO toDelete) {
    customerRepository.delete(toDelete);
  }

  @Override
  public void update(CustomerDAO toUpdate) {
    customerRepository.save(toUpdate);
  }
}
