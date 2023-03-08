package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Order;
import com.example.Ecommerce.service.OrderService;
import com.example.Ecommerce.utils.OrderValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService service;
    @PostMapping("/order")
    public String saveOrder(@RequestBody String order){
        JSONObject jsonObject=new JSONObject(order);
        List<String> valid= OrderValidator.validator(jsonObject);
        if(valid.isEmpty()) {
            Order order1 = service.setOrder(jsonObject);
            service.placeOrder(order1);
            return "order placed";
        }
        return "order not placed";
    }
    @GetMapping("/order/id")
    public ResponseEntity<String> getOrder(@Nullable @RequestParam Integer id){
        return new ResponseEntity<>(service.getOrder(id).toString(), HttpStatus.OK);
    }
}
