package com.springpractice.demospring.repositories;

import com.springpractice.demospring.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
}
