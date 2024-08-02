package com.personalfinance.dto;

import java.util.Date;

public class BudgetDto {
    private double incomeFromSalary;
    private double incomeFromBusiness;
    private double passiveIncome;
    private String userEmail;
    private Date monthofIncome;

    // Getters and setters

    public double getIncomeFromSalary() {
        return incomeFromSalary;
    }

    public void setIncomeFromSalary(double incomeFromSalary) {
        this.incomeFromSalary = incomeFromSalary;
    }

    public double getIncomeFromBusiness() {
        return incomeFromBusiness;
    }

    public void setIncomeFromBusiness(double incomeFromBusiness) {
        this.incomeFromBusiness = incomeFromBusiness;
    }

    public double getPassiveIncome() {
        return passiveIncome;
    }

    public void setPassiveIncome(double passiveIncome) {
        this.passiveIncome = passiveIncome;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

	public Date getMonthofIncome() {
		return monthofIncome;
	}

	public void setMonthofIncome(Date monthofIncome) {
		this.monthofIncome = monthofIncome;
	}

   
}
