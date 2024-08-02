package com.personalfinance.entites;


import java.util.List;

import org.hibernate.annotations.Index;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Index(name = "idx_user_email")
    private String email;

    private String phoneNumber;
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payments> payments;



   
    public User() {}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getConfirmPassword() {
		return confirmPassword;
	}




	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}




	public List<Payments> getPayments() {
		return payments;
	}




	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}




	


	public User(Long id, String firstName, String lastName, String email, String phoneNumber, String password,
			String confirmPassword, List<Payments> payments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.payments = payments;
	}


}
