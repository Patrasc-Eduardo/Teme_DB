package com.springpractice.demospring.repositories;

import com.springpractice.demospring.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
    public List<OrderDetails> getAllOrderDetailsByOrderId(Integer id);
}
