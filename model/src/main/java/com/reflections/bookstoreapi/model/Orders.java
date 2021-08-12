package com.reflections.bookstoreapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String title;
	private int quantity;
	private String asinCode;
	private double totalPrice;
	private String paymentMode;
	private String address;
	private String purchaseDate;

	public Orders() {

	}

	public Orders(int orderId, String title, int quantity, String asinCode, double totalPrice, String paymentMode,
			String address, String purchaseDate) {
		super();
		this.orderId = orderId;
		this.title = title;
		this.quantity = quantity;
		this.asinCode = asinCode;
		this.totalPrice = totalPrice;
		this.paymentMode = paymentMode;
		this.address = address;
		this.purchaseDate = purchaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAsinCode() {
		return asinCode;
	}

	public void setAsinCode(String asinCode) {
		this.asinCode = asinCode;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
