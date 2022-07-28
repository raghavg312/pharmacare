package com.pharmacy.ordermanagement.Controller;


import com.pharmacy.ordermanagement.Entity.Order;
import com.pharmacy.ordermanagement.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity getOrder(){
        List<Order> a = orderService.getOrder();
        if(!(a.isEmpty()))
            return ResponseEntity.ok(a);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no order in the system");
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity getOrderById(@PathVariable("orderId") String id){
        Optional<Order> a = orderService.findOrderById(id);
        if(!(a.isEmpty()))
            return ResponseEntity.ok(a);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no order in the system with id "+id);
        }
    }

    @PostMapping("/order")
    public ResponseEntity createOrder(@RequestBody Order order) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(orderService.saveOrder(order));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Order not created. Check the inputs.");
        }
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity updateOrder(@RequestBody Order order, @PathVariable("orderId") String id){

        try {
            return ResponseEntity.ok(orderService.updateOrder(order,id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Order with id "+id+" not found in the System");
        }
    }

    @DeleteMapping("/order/{orderId}")
    public  ResponseEntity deleteOrder(@PathVariable("orderId") String id){
        try {
            return ResponseEntity.ok(orderService.deleteOrder(id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Order with id "+id+" not found in the System");
        }
    }
}
