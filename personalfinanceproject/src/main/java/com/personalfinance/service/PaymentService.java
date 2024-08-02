package com.personalfinance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.PaymentRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.PaymentRequestDTO;
import com.personalfinance.dto.PaymentResponseDTO;
import com.personalfinance.entites.Payments;
import com.personalfinance.entites.User;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentsRepository;
    
//    @Autowired
//    private StripeClient stripeClient;

    @Autowired
    private UserDao userRepository;

    public PaymentResponseDTO createPaymentIntent(PaymentRequestDTO paymentRequest) throws StripeException {
        System.out.println("Received payment request: " + paymentRequest);
        System.out.println("GET USER " + paymentRequest.getUserEmail());

        // Step 1: Create PaymentIntent on Stripe
        PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
                .setAmount(paymentRequest.getAmount())
                .setCurrency(paymentRequest.getCurrency())
                .addPaymentMethodType(paymentRequest.getPaymentMethodType())
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(createParams);
        System.out.println("PaymentIntent created: " + paymentIntent.getId());

        // Step 2: Save transaction details in database
        User user = userRepository.findByEmail(paymentRequest.getUserEmail());
        System.out.println("Fetched user: " + user);

        if (paymentRequest.getUserEmail() == null || paymentRequest.getUserEmail().isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        Payments payment = new Payments();
        payment.setAmount(paymentRequest.getAmount());
        payment.setCurrency(paymentRequest.getCurrency());
        payment.setPaymentMethodType(paymentRequest.getPaymentMethodType());
        payment.setStatus(paymentIntent.getStatus());
        payment.setStripePaymentIntentId(paymentIntent.getId());
        payment.setUser(user);

        Payments savedPayment = paymentsRepository.save(payment);
        System.out.println("Payment saved: " + savedPayment.getId());

        // Step 3: Create PaymentResponse
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setId(savedPayment.getId());
        response.setAmount(savedPayment.getAmount());
        response.setCurrency(savedPayment.getCurrency());
        response.setPaymentMethodType(savedPayment.getPaymentMethodType());
        response.setStatus(savedPayment.getStatus());
        response.setStripePaymentIntentId(savedPayment.getStripePaymentIntentId());
        response.setUserEmail(user.getEmail());

        return response;
    }
}
