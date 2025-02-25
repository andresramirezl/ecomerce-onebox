package com.ecomerce_onebox.test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.ecomerce_onebox.test.entities.Cart;
import com.ecomerce_onebox.test.entities.Product;

class CartServiceTest {
    
    private CartService cartService;
    private Product testProduct;
    
    @BeforeEach
    void setUp() {
        // Usar un tiempo de expiración corto para testing (1 segundo)
        cartService = new CartService(1000);
        testProduct = new Product(1, "Test Product", 100.0);
    }
    
    @Test
    @DisplayName("should create a cart")
    void testCreateCart() {
        Cart cart = cartService.createCart();
        assertNotNull(cart, "The cart should not be null");
        assertNotNull(cart.getId(), "The cart ID should not be null");
        assertTrue(cart.getProducts().isEmpty(), "The cart should be empty");
    }
    
    @Test
    @DisplayName("should get a cart")
    void testGetCart() {
        Cart createdCart = cartService.createCart();
        Cart retrievedCart = cartService.getCart(createdCart.getId());
        
        assertNotNull(retrievedCart, "The retrieved cart should not be null");
        assertEquals(createdCart.getId(), retrievedCart.getId(), 
            "The cart IDs should match");
    }
    
    @Test
    @DisplayName("should return null for a non-existent cart")
    void testGetNonExistentCart() {
        Cart cart = cartService.getCart(999L);
        assertNull(cart, "The non-existent cart should return null");
    }
    
    @Test
    @DisplayName("should add a product to cart")
    void testAddProductToCart() {
        Cart cart = cartService.createCart();
        cartService.addProductToCart(cart.getId(), testProduct);
        Cart updatedCart = cartService.getCart(cart.getId());
        
        assertNotNull(updatedCart, "The updated cart should not be null");
        assertEquals(1, updatedCart.getProducts().size(), 
            "The cart should have one product");
        assertEquals(testProduct, updatedCart.getProducts().get(0), 
            "The product in the cart should be the same as the one added");
    }
    
    @Test
    @DisplayName("should throw an exception when adding a product to a non-existent cart")
    void testAddProductToNonExistentCart() {
        assertThrows(RuntimeException.class, () -> {
            cartService.addProductToCart(999L, testProduct);
        }, "should throw RuntimeException for a non-existent cart");
    }
    
    @Test
    @DisplayName("should delete a cart")
    void testDeleteCart() {
        Cart cart = cartService.createCart();
        cartService.deleteCart(cart.getId());
        Cart deletedCart = cartService.getCart(cart.getId());
        assertNull(deletedCart, "The deleted cart should not exist");
    }
    
    @Test
    @DisplayName("should expire the cart after the configured time")
    void testCartExpiration() throws InterruptedException {
        Cart cart = cartService.createCart();
        // Esperamos un poco más del tiempo de expiración
        Thread.sleep(1100);
        // Forzamos la verificación de carritos expirados
        cartService.checkExpiredCarts();
        Cart expiredCart = cartService.getCart(cart.getId());
        assertNull(expiredCart, "The cart should have expired");
    }
} 