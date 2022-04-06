package com.example.demo.repository;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerDAO, UUID> {
}
