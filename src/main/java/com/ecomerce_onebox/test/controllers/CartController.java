package com.ecomerce_onebox.test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecomerce_onebox.test.entities.Cart;
import com.ecomerce_onebox.test.entities.Product;
import com.ecomerce_onebox.test.service.CartService;

@RestController 
@RequestMapping("Carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart() {
        return cartService.createCart();
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @PostMapping("/{id}/products")
    public void addProductToCart(@PathVariable Long id, @RequestBody Product product) {
        cartService.addProductToCart(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id); 
    }
}
