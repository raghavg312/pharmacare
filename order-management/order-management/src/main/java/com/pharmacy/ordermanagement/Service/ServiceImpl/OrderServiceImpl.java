package com.pharmacy.ordermanagement.Service.ServiceImpl;

import com.pharmacy.ordermanagement.Entity.Order;
import com.pharmacy.ordermanagement.Service.OrderService;
import com.pharmacy.ordermanagement.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrder() {
        List<Order> order = orderRepository.findAll();
        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        Order orders = orderRepository.save(order);
        return orders;
    }

    @Override
    public Order updateOrder(Order order,String id) {
        Order o= orderRepository.findById(id).get();
        o.setOrder_ID(id);
        o.setDoc_ID(order.getOrder_ID());
        o.setDoc_ID(order.getDoc_ID());
        o.setQuantity(order.getQuantity());
        o.setTotal_Price(order.getTotal_Price());
        o.setPicked_Up(order.getPicked_Up());
        orderRepository.save(o);
        return o;
    }

    @Override
    public String deleteOrder(String id) {
        orderRepository.deleteById(id);
        return id;
    }

    public Optional<Order> findOrderById(String id){
        Optional<Order> a = orderRepository.findById(id);
        return a;
    }
}

