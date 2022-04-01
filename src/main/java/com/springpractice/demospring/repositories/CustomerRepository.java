package com.springpractice.demospring.repositories;

import com.springpractice.demospring.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
