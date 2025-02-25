package com.ecomerce_onebox.test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecomerce_onebox.test.entities.Cart;
import com.ecomerce_onebox.test.entities.Product;
import com.ecomerce_onebox.test.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping("Carts")
@Tag(name = "Carrito", description = "API to manage carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "Create a new cart", 
                description = "Create a new cart and return its details")
    @PostMapping
    public Cart createCart() {
        return cartService.createCart();
    }

    @Operation(summary = "Get a cart by ID")
    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @Operation(summary = "List all carts")
    @GetMapping
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @Operation(summary = "Add products to cart",
                description = "Add a product to the specified cart")
    @PostMapping("/{id}/products")
    public void addProductToCart(@PathVariable Long id, @RequestBody Product product) {
        cartService.addProductToCart(id, product);
    }

    @Operation(summary = "Delete a cart")
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id); 
    }
}
