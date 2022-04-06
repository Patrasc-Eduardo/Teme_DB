package com.example.demo.dao;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderDAO implements IDao<Order> {

  private final OrderRepository orderRepository;

  public Optional<Order> get(Integer id) {
    return orderRepository.findById(id);
  }

  @Override
  public void create(Order toCreate) {
    orderRepository.save(toCreate);
  }

  public Optional<Order> getById(Integer id) {
    return orderRepository.findById(id);
  }

  public List<Order> getAllOrders() {
    List<Order> orders = new ArrayList<>();
    orderRepository.findAll().iterator().forEachRemaining(orders::add);
    return orders;
  }

  @Override
  public void delete(Order toDelete) {
    orderRepository.delete(toDelete);
  }

  public void deleteById(Integer id) {
    orderRepository.deleteById(id);
  }

  @Override
  public void update(Order toUpdate) {
    orderRepository.save(toUpdate);
  }
}
