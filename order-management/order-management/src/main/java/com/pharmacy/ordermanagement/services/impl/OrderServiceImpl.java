package com.pharmacy.ordermanagement.services.impl;

import com.pharmacy.ordermanagement.dao.OrderRepository;
import com.pharmacy.ordermanagement.models.Drug;
import com.pharmacy.ordermanagement.models.Orders;
import com.pharmacy.ordermanagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> getOrder() {
        List<Orders> order = orderRepository.findAll();
        return order;
    }

    @Override
    public Orders getOrderById(String s) {
        return  orderRepository.findById(s).get();
    }

    @Override
    public Orders saveOrder(Orders order) {
        Orders orders= orderRepository.save(order);
        return orders;
    }

    @Override
    public Orders updateOrder(Orders order, String id) {
        Orders updatedOrder= orderRepository.findById(id).get();
        updatedOrder.setDrugList(order.getDrugList());
        double totalPrice = 0;
        for(Drug drug : updatedOrder.getDrugList()){
            totalPrice+=drug.getPrice() * drug.getDrugQuantity();
        }
        updatedOrder.setTotalPrice(totalPrice);
        orderRepository.save(updatedOrder);
        return updatedOrder;
    }



    @Override
    public String deleteOrder(String id) {
        orderRepository.deleteById(id);
        return id;
    }

    @Override
    public boolean verifyOrder(String orderId) {
        Orders orders = orderRepository.findById(orderId).get();
        if(!(orders.isVerified())){
            orders.setVerified(true);
            orderRepository.save(orders);
            return true;
        }
        return false;
    }

    @Override
    public boolean pickUpOrder(String orderId) {
        Orders orders = orderRepository.findById(orderId).get();
        if(!(orders.isVerified())){
            orders.setPickedUp(true);
            orderRepository.save(orders);
            return true;
        }
        return false;
    }

    @Override
    public List<Orders> findByPickedUp(boolean flag) {
        return orderRepository.findByPickedUp(flag);
    }

    @Override
    public List<Orders> findByVerified(boolean flag) {
        return orderRepository.findByVerified(flag);
    }

    @Override
    public List<Orders> findByDoctorId(String id) {
        return orderRepository.findByDoctorId(id);
    }

}
