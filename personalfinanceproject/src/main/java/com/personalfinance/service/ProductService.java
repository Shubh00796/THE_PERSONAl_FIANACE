package com.personalfinance.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.ProductRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.Product;
import com.personalfinance.dto.ProductDTO;
import com.personalfinance.entites.User;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserDao userRepo;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByEmail(ProductDTO productDTO) {
        return productRepository.findByuserEmail(productDTO.getUserEmail());
    }

    public Stream<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category).stream();
    }

    public Product postForProducts(ProductDTO productDTO) {
        User user = userRepo.findByEmail(productDTO.getUserEmail());
        if (user == null) {
            throw new RuntimeException("User not found for email: " + productDTO.getUserEmail());
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setUserEmail(productDTO.getUserEmail());

        return productRepository.save(product);
    }

    public Product createOrUpdateProduct(ProductDTO productDTO) {
        Product product = productRepository.findByNameAndUserEmail(productDTO.getName(), productDTO.getUserEmail());

        if (product == null) {
            // Create a new product if it does not exist
            product = new Product();
            product.setName(productDTO.getName());
            product.setCategory(productDTO.getCategory());
            product.setPrice(productDTO.getPrice());
            product.setUserEmail(productDTO.getUserEmail());
        } else {
            // Update the existing product
            product.setCategory(productDTO.getCategory());
            product.setPrice(productDTO.getPrice());
        }

        return productRepository.save(product);
    }
	   public void deleteProduct(ProductDTO productDTO) {
		   User user = userRepo.findByEmail(productDTO.getUserEmail());
	       if (user == null) {
	           throw new RuntimeException("User not found for email: " + productDTO.getUserEmail());
	       }
       userRepo.delete(user);
		   
	   }
}
