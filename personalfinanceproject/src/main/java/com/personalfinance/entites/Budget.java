package com.personalfinance.entites;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double incomefromSalary;
    private Double incomefromBusiness;
    private Double passiveIncome;

    @Temporal(TemporalType.DATE) // Specify temporal type
    private Date monthofIncome;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
    @JsonBackReference
    private User user;

    // Constructors, getters, setters, and toString() methods
    

    public Budget() {}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getIncomefromSalary() {
		return incomefromSalary;
	}

	public void setIncomefromSalary(Double incomefromSalary) {
		this.incomefromSalary = incomefromSalary;
	}

	public Double getIncomefromBusiness() {
		return incomefromBusiness;
	}

	public void setIncomefromBusiness(Double incomefromBusiness) {
		this.incomefromBusiness = incomefromBusiness;
	}

	public Double getPassiveIncome() {
		return passiveIncome;
	}

	public void setPassiveIncome(Double passiveIncome) {
		this.passiveIncome = passiveIncome;
	}

	public Date getMonthofIncome() {
		return monthofIncome;
	}

	public void setMonthofIncome(Date monthofIncome) {
		this.monthofIncome = monthofIncome;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Budget(Long id, Double incomefromSalary, Double incomefromBusiness, Double passiveIncome, Date monthofIncome, User user) {
        this.id = id;
        this.incomefromSalary = incomefromSalary;
        this.incomefromBusiness = incomefromBusiness;
        this.passiveIncome = passiveIncome;
        this.monthofIncome = monthofIncome;
        this.user = user;
    }

    // Getters and setters
    // ... (rest of the code)
}
