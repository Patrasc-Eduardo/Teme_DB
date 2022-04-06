package com.example.demo.dao;

import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class OrderDAO implements IDao<OrderDAO> {

  private final OrderRepository orderRepository;

  @Override
  public Optional<OrderDAO> get(UUID id) {
    return orderRepository.findById(id);
  }

  @Override
  public void create(OrderDAO toCreate) {
    orderRepository.save(toCreate);
  }

  @Override
  public void delete(OrderDAO toDelete) {
    orderRepository.delete(toDelete);
  }

  @Override
  public void update(OrderDAO toUpdate) {
    orderRepository.save(toUpdate);
  }
}
