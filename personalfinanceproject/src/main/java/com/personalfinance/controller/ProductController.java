package com.personalfinance.controller;


import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.personalfinance.dto.Product;
import com.personalfinance.dto.ProductDTO;
import com.personalfinance.service.ProductService;

@RestController
//@CrossOrigin(origins = "*")

@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        return productService.postForProducts(productDTO);
    }
    
    @PutMapping
    public ResponseEntity<Product> createOrUpdateProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.createOrUpdateProduct(productDTO);
        return ResponseEntity.ok(product);
    }
    
    

   

    @GetMapping("/by-category/{category}")
    public ResponseEntity<Stream<Product>> getProductsByCategory(@PathVariable String category) {
        Stream<Product> products = productService.getProductsByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
