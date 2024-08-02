package com.personalfinance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalfinance.dto.BalanceSummaryDTO;
import com.personalfinance.entites.BalanceSummary;

@Repository
public interface BalanceSummaryRepository extends JpaRepository<BalanceSummary, Long> {

	List<BalanceSummary> findByUserEmail(String userEmail);

	
	
}
