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

import com.personalfinance.dto.BalanceSummaryDTO;
import com.personalfinance.service.BalanceSumary;

@RestController
@RequestMapping("balance-summary")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class BalanceSummaryController {

    @Autowired
    private BalanceSumary balanceSummaryService;

    @PostMapping
    public ResponseEntity<BalanceSummaryDTO> createBalanceSummary(@RequestBody BalanceSummaryDTO balanceSummaryDto) {
    	BalanceSummaryDTO createdBalanceSummary = balanceSummaryService.createReport(balanceSummaryDto);
        return ResponseEntity.ok(createdBalanceSummary);
    }
    @GetMapping("/{userEmail}")
    public List<BalanceSummaryDTO> getBalanceSummariesByUserEmail(@PathVariable String userEmail) {
        return balanceSummaryService.getBalanceSummaryByUserEmail(userEmail);
    }
}
