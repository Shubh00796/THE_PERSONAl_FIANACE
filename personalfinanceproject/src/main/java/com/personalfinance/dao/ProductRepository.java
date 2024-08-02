package com.personalfinance.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalfinance.dto.Product;
import com.personalfinance.dto.ProductDTO;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    
    Product findByuserEmail(String userEmail);
    
    Product findByNameAndUserEmail(String name, String userEmail);

    

}
