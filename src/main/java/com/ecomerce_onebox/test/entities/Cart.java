
package com.ecomerce_onebox.test.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cart {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);
    private long id;
    private List<Product> products;
    private long LastActiveTime;

    public Cart() {
        this.id = ID_GENERATOR.incrementAndGet();
        this.products = new ArrayList<>();
        this.LastActiveTime = System.currentTimeMillis();
    }
    
}
