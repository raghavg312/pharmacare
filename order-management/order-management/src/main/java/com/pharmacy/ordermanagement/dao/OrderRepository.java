package com.pharmacy.ordermanagement.dao;

import com.pharmacy.ordermanagement.Entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,String> {
    public List<Order> findAll();
}
