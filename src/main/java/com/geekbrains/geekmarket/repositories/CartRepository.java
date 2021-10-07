package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartRepository {
	Map<String, Cart> carts;
	
	public CartRepository () {
		carts = new HashMap<>();
	}
	
	public Cart getCart(String userName) {
		if (!carts.containsKey(userName)) {
			return carts.put(userName, new Cart());
		} else {
			return carts.get(userName);
		}
	}
}
