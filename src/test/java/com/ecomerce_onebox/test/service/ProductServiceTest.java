package com.ecomerce_onebox.test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecomerce_onebox.test.entities.Product;

class ProductServiceTest {
    
    private ProductService productService;
    
    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }
    
    @Test
    void testGetProducts() {
        assertNotNull(productService.getProducts());
        assertEquals(5, productService.getProducts().size());
    }
    
    @Test
    void testGetProductById() {
        Product product = productService.getProductById(1);
        assertNotNull(product);
        assertEquals("Product 1", product.getDescription());
        assertEquals(100.0, product.getAmount());
    }
    
    @Test
    void testGetProductByIdNotFound() {
        Product product = productService.getProductById(999);
        assertNull(product);
    }
    
    @Test
    void testAddProduct() {
        Product newProduct = new Product(6, "New Product", 600.0);
        Product added = productService.addProduct(newProduct);
        assertNotNull(added);
        assertEquals(6, productService.getProducts().size());
        assertEquals(newProduct, productService.getProductById(6));
    }
    
    @Test
    void testUpdateProduct() {
        Product updateProduct = new Product(1, "Updated Product", 150.0);
        Product updated = productService.updateProduct(1L, updateProduct);
        assertNotNull(updated);
        assertEquals("Updated Product", updated.getDescription());
        assertEquals(150.0, updated.getAmount());
    }
    
    @Test
    void testDeleteProduct() {
        productService.deleteProduct(1L);
        assertNull(productService.getProductById(1));
        assertEquals(4, productService.getProducts().size());
    }
} 