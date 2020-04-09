package com.spain.csd.os.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	private int id;
	private String name;
	private int quantity;
	private double amount;
	public Order() {
		super();
	}
	public Order(int id, String name, int quantity, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
