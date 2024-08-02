package com.personalfinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.OrderRequestDto;
import com.personalfinance.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{email}")
    public ResponseEntity<String> placeOrder(@PathVariable String email ,@RequestBody List<OrderRequestDto> orderRequests) {
        String response = orderService.placeOrder(orderRequests, email);
        return ResponseEntity.ok(response);
    }
}
