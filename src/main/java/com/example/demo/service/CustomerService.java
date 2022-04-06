package com.example.demo.service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
  @Autowired private CustomerDAO customerDAO;

  public Optional<Customer> get(Integer id) {
    return customerDAO.get(id);
  }

  public Optional<Customer> getByUsername(String username) {
    return customerDAO.getByUsername(username);
  }

  public List<Customer> getByCity(String city) {
    return customerDAO.getByCity(city);
  }

  public List<Customer> getByCountry(String country) {
    return customerDAO.getByCountry(country);
  }

  public List<Customer> getAllCustomers() {
    return customerDAO.getAllCustomers();
  }

  public void create(Customer toCreate) {
    customerDAO.create(toCreate);
  }

  public void delete(Customer toDelete) {
    customerDAO.delete(toDelete);
  }

  public void deleteById(Integer id) {
    customerDAO.deleteById(id);
  }

  public void update(Customer toUpdate) {
    customerDAO.update(toUpdate);
  }
}
