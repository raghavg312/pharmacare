package com.pharmacy.ordermanagement.controller;

import com.pharmacy.ordermanagement.config.EmailSenderService;
import com.pharmacy.ordermanagement.models.*;
import com.pharmacy.ordermanagement.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EmailSenderService senderService;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping()
    public ResponseEntity getOrder() {
        try {
            return ResponseEntity.ok(orderService.getOrder());
        } catch (Exception e) {
            logger.error("No order in the system");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }

    @GetMapping("/pickUp/{orderId}")
    public ResponseEntity orderPickUp(@PathVariable("orderId") String orderId) {
        try {
            boolean flag = orderService.pickUpOrder(orderId);
            if(flag) {
                return ResponseEntity.status(HttpStatus.OK).body("order added to picked-up section");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No order found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @GetMapping("/verify/{orderId}")
    public ResponseEntity verifyOrder(@PathVariable("orderId") String orderId) {
        try {
            boolean flag = orderService.verifyOrder(orderId);
            if(flag) {
                return ResponseEntity.status(HttpStatus.OK).body("order verified");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No order found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(orderService.getOrderById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }

    @PostMapping()
    public ResponseEntity createOrder(@RequestBody OrderProcessing orderProcessing) {
        try {

            List<OrderedDrug> orderedDrugList = orderProcessing.getOrderedDrugList();
            List<Drug> drugList = new ArrayList<>();

            Doctor doctor = restTemplate.getForObject("http://user-management/doctor/" + orderProcessing.getDoctorId(), Doctor.class);
            double totalPrice = 0;

            Orders order1 = new Orders();
            order1.setDoctorId(orderProcessing.getDoctorId());
            order1.setPickedUp(false);
            order1.setVerified(false);

            List<Orders> orList = new ArrayList<>();
            orList.add(order1);

            for (OrderedDrug orderedDrug : orderedDrugList) {
                Drug drug = restTemplate.getForObject("http://drug-management/drug/" + orderedDrug.getDrugId(), Drug.class);
                drug.setDrugQuantity(orderedDrug.getQuantity());
                totalPrice += drug.getPrice() * orderedDrug.getQuantity();
                drugList.add(drug);
            }

            order1.setDrugList(drugList);
            order1.setTotalPrice(totalPrice);
            Orders orders = orderService.saveOrder(order1);
            new ResponseEntity<>(orders, HttpStatus.CREATED);

//        ResponseEntity.status(HttpStatus.CREATED)
//                .body(orderService.saveOrder(order1));
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(senderService.sendSimpleEmail(doctor.getDoctor_email(),
                            "PHARMACARE: New Order ",
                            "Hey " + doctor.getDoctor_name() + "    " +
                                    "Thanks for your purchase from Pharmacare " +
                                    " Order id : " + orders.getOrderId() +
                                    " Price : " + orders.getTotalPrice()
                    ));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("something is wrong");
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity updateOrder(@RequestBody Orders order, @PathVariable("orderId") String id) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(order,id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable("orderId") String id) {
        try {
            return ResponseEntity.ok(orderService.deleteOrder(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }

    @GetMapping("/byPickedUp/{flag}")
    public ResponseEntity findByPickedUp(@PathVariable("flag") boolean flag){
        try {
            return ResponseEntity.ok(orderService.findByPickedUp(flag));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }

    @GetMapping("/byVerified/{flag}")
    public ResponseEntity findByVerified(@PathVariable("flag") boolean flag){
        try {
            return ResponseEntity.ok(orderService.findByVerified(flag));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }

    @GetMapping("/byDoctorId/{id}")
    public ResponseEntity findByDoctorId(@PathVariable("id") String id){
        try {
            return ResponseEntity.ok(orderService.findByDoctorId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }
}