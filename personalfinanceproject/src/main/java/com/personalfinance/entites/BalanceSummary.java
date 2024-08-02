package com.personalfinance.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class BalanceSummary {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private double maxAmountToBeSpend;
	    private double enterTheBalanceYouWantToAdd;
	    private double amountToBeSaved;
	
	    
	    
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
		
		 
		public BalanceSummary(Long id, double maxAmountToBeSpend, double enterTheBalanceYouWantToAdd,
				double amountToBeSaved) {
			super();
			this.id = id;
			this.maxAmountToBeSpend = maxAmountToBeSpend;
			this.enterTheBalanceYouWantToAdd = enterTheBalanceYouWantToAdd;
			this.amountToBeSaved = amountToBeSaved;
		}
		@ManyToOne
	    @JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
	    private User user;
		
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public BalanceSummary() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "BalanceSummary [id=" + id + ", maxAmountToBeSpend=" + maxAmountToBeSpend
					+ ", enterTheBalanceYouWantToAdd=" + enterTheBalanceYouWantToAdd + ", amountToBeSaved="
					+ amountToBeSaved + "]";
		}
		
		
}
