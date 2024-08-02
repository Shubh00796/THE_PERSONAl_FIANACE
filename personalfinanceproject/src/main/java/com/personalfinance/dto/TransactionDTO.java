package com.personalfinance.dto;

import java.util.Date;

import com.personalfinance.entites.Categories;

public class TransactionDTO {
    private double amount;
    private Categories category;
    private String userEmail;
    private UserDto user;
    private Date date;
    private long id;


      
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	// Getters and setters
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Categories getCategory() { return category; }
    public void setCategory(Categories category) { this.category = category; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}
