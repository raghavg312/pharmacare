package com.pharmacy.salesmanagement.Controller;

import com.pharmacy.salesmanagement.Model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Controller
@RequestMapping
public class SalesController {
    @Autowired
    RestTemplate restTemplate;

    ResponseEntity<Orders[]> response =
            restTemplate.getForEntity(
                    "http://localhost:8064/order/",
                    Orders[].class);
    Orders[] o = response.getBody();

    @GetMapping("/sales")
    public Integer TotalSale(){
//        List<Orders> orders = restTemplate.get;
        int totalSale = 0;

        for(Orders orders: o)
        {
            totalSale+=orders.getTotalPrice();
        }
        return totalSale;
    }

    public Integer SaleByDrugId(){

        return 1;
    }

    public Integer SaleByDocId(){
        return 1;
    }

//    public Integer SaleBy(){
//        return 1;
//    }

}

