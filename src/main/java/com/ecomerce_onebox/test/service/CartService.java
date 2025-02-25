package com.ecomerce_onebox.test.service;

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

    public CartService() {
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

    /* delete a cart */
    public void deleteCart(Long cartId) {
        carts.remove(cartId);
    }

    /* remove expired carts */
    private void removeExpiredCarts() {
        long currentTime = System.currentTimeMillis();
        //carts.entrySet().removeIf(entry -> (now - entry.getValue().getLastActiveTime()) > 600000);
        carts.values().removeIf(cart -> currentTime - cart.getLastActiveTime() > 1000 * 60 * 10);
    }
}
