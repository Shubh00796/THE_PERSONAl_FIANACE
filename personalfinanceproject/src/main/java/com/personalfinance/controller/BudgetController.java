package com.personalfinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.BudgetDto;
import com.personalfinance.entites.Budget;
import com.personalfinance.service.Budgetservice;

@RestController
@RequestMapping("/budget")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class BudgetController {

    @Autowired
    private Budgetservice budgetService;

    @PostMapping("/income")
    public ResponseEntity<Budget> createBudget(@RequestBody BudgetDto budgetDto) {
        Budget budget = budgetService.createBudget(budgetDto);
        return new ResponseEntity<>(budget, HttpStatus.CREATED);
    }

    @GetMapping("/income/{email}")
    public ResponseEntity<List<BudgetDto>> getBudgetByEmail(@PathVariable String email) {
        List<BudgetDto> budgetDtos = budgetService.getBudgetByEmail(email);
        return new ResponseEntity<>(budgetDtos, HttpStatus.OK);
    }
}


