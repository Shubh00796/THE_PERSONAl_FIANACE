package com.personalfinance.entites;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

   
	  public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", user=" + user + "]";
	}


	public Account(Long id, double balance, User user) {
		super();
		this.id = id;
		this.balance = balance;
		this.user = user;
	}


	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	@ManyToOne
	    @JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
	    @JsonBackReference
	    private User user;

    
    // Getters and setters
}