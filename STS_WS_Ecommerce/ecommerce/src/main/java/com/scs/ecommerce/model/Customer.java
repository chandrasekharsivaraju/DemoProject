package com.scs.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Customer {

	@Id
	@GeneratedValue	
	private Long custId;

	@Size(min = 4)
	private String Name;

	@NotBlank
	private String Address;
	
	@OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "co_fk",referencedColumnName = "custId")
	private List<Order> orders;

	
	public Customer() {
		super();
	}

	public Customer(Long custId, @Size(min = 4) String name, String address, List<Order> orders) {
		super();
		this.custId = custId;
		Name = name;
		Address = address;
		this.orders = orders;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", Name=" + Name + ", Address=" + Address + ", orders=" + orders + "]";
	}


}
