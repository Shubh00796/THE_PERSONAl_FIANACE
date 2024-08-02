package com.personalfinance.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.BudgetRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.BudgetDto;
import com.personalfinance.entites.Budget;
import com.personalfinance.entites.User;

@Service
public class BudgetImpl implements Budgetservice {


    @Autowired
    private BudgetRepository budgetrepo;

    @Autowired
    private UserDao userRepository;

    @Override
    public Budget createBudget(BudgetDto budgetdto) {

        User user = userRepository.findByEmail(budgetdto.getUserEmail());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Budget budget = new Budget();
        budget.setIncomefromBusiness(budgetdto.getIncomeFromBusiness());
        budget.setIncomefromSalary(budgetdto.getIncomeFromSalary());
        budget.setPassiveIncome(budgetdto.getPassiveIncome());
        budget.setMonthofIncome(budgetdto.getMonthofIncome());
        budget.setUser(user);

        return budgetrepo.save(budget);
    }

    @Override
    public List<BudgetDto> getBudgetByEmail(String Email) {
        List<Budget> budget = budgetrepo.findByUserEmail(Email);

        if (budget.isEmpty()) {
            throw new IllegalArgumentException("Balance summary not found for user with email: " + Email);
        }

        List<BudgetDto> budgetdtos = new ArrayList<>();

        for (Budget budgets : budget) {
            BudgetDto bd = new BudgetDto();
            bd.setIncomeFromBusiness(budgets.getIncomefromBusiness());
            bd.setIncomeFromSalary(budgets.getIncomefromSalary());
            bd.setPassiveIncome(budgets.getIncomefromBusiness());
            bd.setUserEmail(budgets.getUser().getEmail());
            System.out.println("EMAIL ID " + budgets.getUser().getEmail());
            bd.setMonthofIncome(budgets.getMonthofIncome());;
            budgetdtos.add(bd);
        }
        return budgetdtos;
    }
}
