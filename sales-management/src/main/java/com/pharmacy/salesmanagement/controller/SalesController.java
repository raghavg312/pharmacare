package com.pharmacy.salesmanagement.controller;

import com.pharmacy.salesmanagement.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SalesController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/sales/total")
    public Double TotalSales() {
        ResponseEntity<Orders[]> response = restTemplate.getForEntity(
                "http://localhost:8064/order/orders",
                Orders[].class);
        Orders[] o = response.getBody();
        Double totalSale = 0.0;
        for (Orders orders1 : o)
            totalSale += orders1.getTotalPrice();
        return totalSale;
    }

    @GetMapping("/{drugId}")
    public Double SaleByDocId(@PathVariable("drugId") String id) {
        ResponseEntity<Orders[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8064/order/" + id,
                        Orders[].class);
        Orders[] o = response.getBody();
        Double totalSale = 0.0;

        for (Orders orders : o)
            totalSale += orders.getTotalPrice();
        return totalSale;
    }
}
