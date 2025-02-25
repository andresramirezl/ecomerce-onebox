package com.ecomerce_onebox.test.service;

import java.util.ArrayList;
import java.util.List;  

import org.springframework.stereotype.Service;

import com.ecomerce_onebox.test.entities.Product;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    
    public ProductService() {
        products.add(new Product(1, "Product 1", 100.0));
        products.add(new Product(2, "Product 2", 200.0));  
        products.add(new Product(3, "Product 3", 300.0));
        products.add(new Product(4, "Product 4", 400.0));
        products.add(new Product(5, "Product 5", 500.0));
    }
    
    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setDescription(product.getDescription());
            existingProduct.setAmount(product.getAmount());
        }
        return existingProduct;
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId() == id);  // Usamos == para comparar primitivos
    }
}

