package com.personalfinance.dto;

import com.personalfinance.entites.User;
public class BalanceSummaryDTO {

    private Long id;
    private double maxAmountToBeSpend;
    private double enterTheBalanceYouWantToAdd;
    private double amountToBeSaved;
    private String userEmail;

    // Default constructor
    public BalanceSummaryDTO() {
    }

    // Parameterized constructor
    public BalanceSummaryDTO(Long id, double maxAmountToBeSpend, double enterTheBalanceYouWantToAdd, double amountToBeSaved, String userEmail) {
        this.id = id;
        this.maxAmountToBeSpend = maxAmountToBeSpend;
        this.enterTheBalanceYouWantToAdd = enterTheBalanceYouWantToAdd;
        this.amountToBeSaved = amountToBeSaved;
        this.userEmail = userEmail;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMaxAmountToBeSpend() {
        return maxAmountToBeSpend;
    }

    public void setMaxAmountToBeSpend(double maxAmountToBeSpend) {
        this.maxAmountToBeSpend = maxAmountToBeSpend;
    }

    public double getEnterTheBalanceYouWantToAdd() {
        return enterTheBalanceYouWantToAdd;
    }

    public void setEnterTheBalanceYouWantToAdd(double enterTheBalanceYouWantToAdd) {
        this.enterTheBalanceYouWantToAdd = enterTheBalanceYouWantToAdd;
    }

    public double getAmountToBeSaved() {
        return amountToBeSaved;
    }

    public void setAmountToBeSaved(double amountToBeSaved) {
        this.amountToBeSaved = amountToBeSaved;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}