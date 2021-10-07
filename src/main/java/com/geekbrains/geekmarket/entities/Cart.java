package com.geekbrains.geekmarket.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Component
public class Cart {
	
//	@Id
//	private String userName;
	private Map<Product, Integer> productMap;
	private double totalCost;
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public Map<Product, Integer> getProductMap() {
		return productMap;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public Cart() {
//		this.userName = userName;
		productMap = new HashMap<>();
		totalCost = 0.0;
	}
}
