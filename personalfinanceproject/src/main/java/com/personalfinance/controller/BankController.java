package com.personalfinance.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.AccountDTO;
import com.personalfinance.entites.Account;
import com.personalfinance.entites.RateLimiter;
import com.personalfinance.service.BankService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class BankController {

    @Autowired
    private BankService bankService;

    @Autowired
    private RateLimiter rateLimiter;

    @GetMapping("/checkBalance")
    public String checkBalance(@RequestParam String userEmail) {
        Long userId = (long) userEmail.hashCode();
        if (rateLimiter.allowRequest(userId)) {
            Optional<Double> balance = bankService.checkBalance(userEmail);
            return balance.map(b -> "Current balance: " + b).orElse("Account not found");
        } else {
            return "Rate limit exceeded. Please try again later.";
        }
        
    }
    
    @PutMapping("/accounts")
    public ResponseEntity<Account> createOrUpdateAccount(@RequestBody AccountDTO accountDTO) {
        Account account = bankService.createOrUpdateAccount(accountDTO);
        return ResponseEntity.ok(account);
    }


}
