package com.geekbrains.geekmarket.controllers;


import com.geekbrains.geekmarket.entities.Cart;
import com.geekbrains.geekmarket.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cart")
public class CartController {
    CartService cartService;
    
    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }
    
    @GetMapping("")
    public String showCartPage(Model model,
                               @AuthenticationPrincipal User user,
                               @ModelAttribute("Cart") Cart cart) {
        
        model.addAttribute("cart", cartService.getCart(user.getUsername()));
        
        return "cart-page";
    }
    
    @GetMapping("/inc/{productId}")
    public String increaseProduct(@RequestParam("productId") Long productId) {
        cartService.increase(productId);
        return "cart-page";
    }

    @GetMapping("/dec/{productId}")
    public void decreaseProduct(@RequestParam("productId") Long productId) {
        cartService.decrease(productId);
    }
    

    @PostMapping("/add")
    public void addProductToCartPost(@ModelAttribute("productId") String productId) {
        cartService.addToCart(Long.parseLong(productId));
    }
    
}
