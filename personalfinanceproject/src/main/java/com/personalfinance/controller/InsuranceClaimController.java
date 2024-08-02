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
import com.personalfinance.dto.InsuranceClaimDTO;
import com.personalfinance.entites.InsuranceClaim;
import com.personalfinance.service.InsuranceClaimImpl;

@RestController
@RequestMapping("/insurance")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class InsuranceClaimController {

    @Autowired
    private InsuranceClaimImpl insuranceClaimService;

    @PostMapping
    public ResponseEntity<InsuranceClaim> createInsuranceClaim(@RequestBody InsuranceClaimDTO insuranceClaimDTO) {
        try {
            InsuranceClaim createdClaim = insuranceClaimService.createClaim(insuranceClaimDTO);
            return new ResponseEntity<>(createdClaim, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
@GetMapping("/claim/{Email}")
 public ResponseEntity<List<InsuranceClaimDTO>> createByEmail(@PathVariable String Email){
	 List<InsuranceClaimDTO> dtos = insuranceClaimService.getInsuranceByEmail(Email);
	 return new ResponseEntity<>(dtos, HttpStatus.OK);
 }
// @GetMapping("/income/{email}")
// public ResponseEntity<List<BudgetDto>> getBudgetByEmail(@PathVariable String email) {
//     List<BudgetDto> budgetDtos = budgetService.getBudgetByEmail(email);
//     return new ResponseEntity<>(budgetDtos, HttpStatus.OK);
// }
    
}
