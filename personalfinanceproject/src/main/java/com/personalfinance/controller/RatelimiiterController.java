package com.personalfinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.entites.RateLimiter;

@RestController
@RequestMapping("/api")
public class RatelimiiterController {

    @Autowired
    private RateLimiter rateLimiter;

    @PostMapping("/ratelimiiter")
    public String transactionEndpoint(@RequestParam Long userId) {
        if (rateLimiter.allowRequest(userId)) {
            // Logic to handle the transaction
            return "Transaction allowed";
        } else {
            return "Rate limit exceeded";
        }
    }
}
