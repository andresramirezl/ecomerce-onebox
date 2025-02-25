package com.ecomerce_onebox.test.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private long id;
    private String description;
    private double amount;
    
    public Product(long id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }

}
