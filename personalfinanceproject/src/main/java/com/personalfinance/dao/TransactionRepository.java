package com.personalfinance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalfinance.entites.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByUserEmail(String email);

}
