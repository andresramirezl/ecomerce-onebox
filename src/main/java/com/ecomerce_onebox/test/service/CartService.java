package com.ecomerce_onebox.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

import com.ecomerce_onebox.test.entities.Cart;
import com.ecomerce_onebox.test.entities.Product;

@Service
public class CartService {

    private final Map<Long, Cart> carts = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final long expirationTime; // en milisegundos

    public CartService() {
        this(600000); // 10 minutos por defecto
    }

    // Constructor para testing
    public CartService(long expirationTime) {
        this.expirationTime = expirationTime;
        scheduler.scheduleAtFixedRate(this::removeExpiredCarts, 1, 1, TimeUnit.MINUTES);
    }

    /* create a new cart */
    public Cart createCart() {
        Cart cart = new Cart();
        carts.put(cart.getId(), cart);
        return cart;
    }

    /* get a cart by id */
    public Cart getCart(long id) {
        Cart cart = carts.get(id);
        if (cart != null) {
            cart.setLastActiveTime(System.currentTimeMillis());
        }
        return cart;
    }

    /* add a product to a cart */
    public void addProductToCart(Long cartId, Product product) {
        Cart cart = getCart(cartId);
        if (cart == null) {
            throw new RuntimeException("Cart not found");
        }
        cart.getProducts().add(product);
        cart.setLastActiveTime(System.currentTimeMillis());
    }

    /* get all carts */
    public List<Cart> findAll() {
        return new ArrayList<>(carts.values());
    }

    /* delete a cart */
    public void deleteCart(Long cartId) {
        carts.remove(cartId);
    }

    /* remove expired carts */
    private void removeExpiredCarts() {
        long currentTime = System.currentTimeMillis();
        carts.values().removeIf(cart -> 
            (currentTime - cart.getLastActiveTime()) > expirationTime);
    }

    // Método para testing
    public void checkExpiredCarts() {
        removeExpiredCarts();
    }
}
