package com.personalfinance.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalfinance.entites.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {
}
