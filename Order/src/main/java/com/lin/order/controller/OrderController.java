package com.lin.order.controller;

import com.lin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("just/test")
    public String test(){
        return orderService.test();
    }
}
