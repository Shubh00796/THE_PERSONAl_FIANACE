package com.personalfinance.dto;

import com.personalfinance.entites.User;

public class PaymentRequestDTO {
    private Long amount;
    private String currency;
    private String paymentMethodType;
    private String userEmail;
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPaymentMethodType() {
		return paymentMethodType;
	}
	public void setPaymentMethodType(String paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "PaymentRequestDTO [amount=" + amount + ", currency=" + currency + ", paymentMethodType="
				+ paymentMethodType + ", userEmail=" + userEmail + "]";
	}
	public PaymentRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
