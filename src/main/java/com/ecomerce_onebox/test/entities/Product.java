package com.ecomerce_onebox.test.entities;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);
    private long id;
    private String description;
    private double amount;
    
    public Product(long id, String description, double amount) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.description = description;
        this.amount = amount;
    }

}
