package com.personalfinance.service;

import java.util.List;

import com.personalfinance.dto.BalanceSummaryDTO;

public interface BalanceSumary {
	BalanceSummaryDTO createReport(BalanceSummaryDTO balanceSummaryDto); 
	List<BalanceSummaryDTO> getBalanceSummaryByUserEmail(String userEmail);
}
