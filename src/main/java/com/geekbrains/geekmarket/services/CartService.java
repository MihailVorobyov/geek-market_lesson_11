package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Cart;
import com.geekbrains.geekmarket.entities.Product;
import com.geekbrains.geekmarket.entities.User;
import com.geekbrains.geekmarket.repositories.CartRepository;
import com.geekbrains.geekmarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CartService {
    private static Map<String, Cart> cartRepository = new HashMap<>();
    Cart cart;
    ProductRepository productRepository;
//
//    @Autowired
//    public void setCartRepository() {
//        cartRepository = ;
//    }
//
    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public Cart getCart(String userName) {
//        Cart cart = cartRepository.get(userName);
//        if (cart == null) {
//            cartRepository.put(userName, new Cart());
//            return cartRepository.get(userName);
//        }
        return cart;
    }
    
    public void addToCart (Long productId) {
        increase(productId);
    }
    
    public void increase (Long productId) {
        Product product = productRepository.myQuery(productId);
        Map<Product, Integer> productMap = cart.getProductMap();
        
        productMap.putIfAbsent(product, 1);
        productMap.computeIfPresent(product, (k, v) -> v + 1);
        cart.setTotalCost(productMap.entrySet().stream().mapToDouble(s -> s.getKey().getPrice() * s.getValue()).sum());
        
    }
    
    public void decrease (Long productId) {
        Product product = productRepository.myQuery(productId);
        Map<Product, Integer> productMap = cart.getProductMap();
    
        productMap.computeIfPresent(product, (k, v) -> v - 1);
        cart.setTotalCost(productMap.entrySet().stream().mapToDouble(s -> s.getKey().getPrice() * s.getValue()).sum());

    }
    
}
