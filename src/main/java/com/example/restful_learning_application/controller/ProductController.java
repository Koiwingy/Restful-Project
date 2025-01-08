package com.example.restful_learning_application.controller;

import com.example.restful_learning_application.model.Product;
import com.example.restful_learning_application.model.ProductID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }
    @GetMapping("/product")
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        result.add(new Product( "1",
                "Product1",
                new BigDecimal("100")));

        result.add(new Product( "2",
                "Product2",
                new BigDecimal("200")));

        result.add(new Product( "3",
                "Product3",
                new BigDecimal("300")));

        return result;
    }
    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable final String id) {
        System.out.println(id);
        return new Product( "888",
                "Returning a product",
                new BigDecimal("48.12"));
    }
    @PatchMapping("/product")
    public void patchProduct(@RequestBody final Product product) {
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id) {
        System.out.println(id);
    }
}
