package com.personalfinance.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.TransactionDTO;
import com.personalfinance.entites.Transaction;
import com.personalfinance.service.TransactionService;


@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = transactionService.createTransaction(transactionDTO);
        return ResponseEntity.ok(transaction);
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
    @GetMapping("/{email}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByEmail(@PathVariable String email) {
        List<TransactionDTO> transactions = transactionService.getTransactionByEmail(email);
        if (transactions == null || transactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transactions);
    }
    
    
    @GetMapping("/categories")
    public List<TransactionDTO> getTransactionCategories() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return transactionService.listOfCategories(transactions);
    }
    @GetMapping("categories/{email}")
    public List<TransactionDTO> getCatehoriesByEmail1(@PathVariable String email) {
        return transactionService.listOfCategoriesByEmail(email);
    }



}


