package com.scs.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "customerorder")
public class Order {

	@Id
	private Long orderId;

	private String productName;

	public Order(Long orderId, String productName) {
		super();
		this.orderId = orderId;
		this.productName = productName;

	}

	public Order() {
		super();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + "]";
	}

}
