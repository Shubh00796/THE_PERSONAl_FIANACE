package com.personalfinance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinance.dto.PaymentRequestDTO;
import com.personalfinance.dto.PaymentResponseDTO;
import com.personalfinance.service.PaymentService;
import com.stripe.exception.StripeException;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO paymentRequest) throws StripeException {
        return paymentService.createPaymentIntent(paymentRequest);
    }
}
