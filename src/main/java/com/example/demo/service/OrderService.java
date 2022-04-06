package com.example.demo.service;

import com.example.demo.dao.OrderDAO;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDao;

    public Optional<Order> get(Integer id) {
        return orderDao.get(id);
    }

    public void create(Order toCreate) {
        orderDao.create(toCreate);
    }

    public Optional<Order> getById(Integer id) {
        return orderDao.get(id);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public void delete(Order toDelete) {
        orderDao.delete(toDelete);
    }

    public void deleteById(Integer id) {
        orderDao.deleteById(id);
    }

    public void update(Order toUpdate) {
        orderDao.update(toUpdate);
    }
}
