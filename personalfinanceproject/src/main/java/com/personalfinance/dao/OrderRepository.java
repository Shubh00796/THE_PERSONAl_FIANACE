package com.personalfinance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalfinance.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
}