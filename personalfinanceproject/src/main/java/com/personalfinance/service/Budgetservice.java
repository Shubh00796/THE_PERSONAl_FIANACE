package com.personalfinance.service;

import java.util.List;

import com.personalfinance.dto.BudgetDto;
import com.personalfinance.entites.Budget;

public interface Budgetservice {
	
	Budget createBudget(BudgetDto budgetdto);
	
	List<BudgetDto> getBudgetByEmail(String Email);
	

}
