package com.personalfinance.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", userEmail="
				+ userEmail + "]";
	}
	public Product(Long id, String name, String category, double price, String userEmail) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.userEmail = userEmail;
	}
	private String category;
    private double price;
    private String userEmail;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
}
