package com.example.demo.service;

import com.example.demo.dto.CustomerAuthDTO;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
  @Autowired private CustomerRepository customerRepository;

  public Optional<Customer> get(Integer id) {

    return customerRepository.findById(id);
  }

  public Optional<Customer> getByUsername(String username) {
    return customerRepository.findByUsername(username);
  }

  public List<Customer> getByCity(String city) {
    return customerRepository.findByCity(city);
  }

  public List<Customer> getByCountry(String country) {
    return customerRepository.findByCountry(country);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public void createCustomer(Customer toCreate) {
    final String secretKey = toCreate.getEmail();
    String givenPassword = toCreate.getUsername();

    // Deocamdata am folosit o metoda banala de criptare
    // punand la sfarsitul parolei emailul.
    if (secretKey != null && givenPassword != null) {
      toCreate.setPassword(givenPassword.concat(secretKey));
    }
    System.err.println(toCreate.getPassword());
    customerRepository.save(toCreate);
  }

  public void delete(Customer toDelete) {
    customerRepository.delete(toDelete);
  }

  public void deleteById(Integer id) {
    customerRepository.deleteById(id);
  }

  public void update(Customer toUpdate) {
    customerRepository.save(toUpdate);
  }

  public boolean exists(String username) {
    return customerRepository.findByUsername(username).isPresent();
  }

  public boolean validateLogin(CustomerAuthDTO info) {
    Optional<Customer> dbCustomer = customerRepository.findByUsername(info.getUsername());

    if (dbCustomer.isPresent()) {
      return info.getPassword() // partea de decriptare a parolei
              .equals(dbCustomer.get().getPassword().replace(info.getEmail(), ""))
          && info.getEmail().equals(dbCustomer.get().getEmail());
    }

    return false;
  }
}
