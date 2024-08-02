package com.personalfinance.dto;

import java.util.List;

public class OrderRequestDto {
	  private String skuCode;
	    private String color;
	    private String size;
	    private int quantity;
	    private String userEmail;
	    private String orderId;
	    public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		private boolean isInStock;
		public boolean isInStock() {
			return isInStock;
		}
		public void setInStock(boolean isInStock) {
			this.isInStock = isInStock;
		}
		public String getSkuCode() {
			return skuCode;
		}
		public void setSkuCode(String skuCode) {
			this.skuCode = skuCode;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
}
