package com.personalfinance.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.personalfinance.dao.OrderRepository;
import com.personalfinance.dto.InventoryResponseDto;
import com.personalfinance.dto.OrderRequestDto;
import com.personalfinance.entites.Order;
import com.personalfinance.utils.OrderIdGenerator;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;
    
  
    
   

    @Transactional
    public String placeOrder(List<OrderRequestDto> orderRequests, String email) {
        // Construct query parameters with multiple SKU codes, colors, and sizes

    	
        String queryParams = orderRequests.stream()
                .map(order -> "quantity" + order.getQuantity() + "&skuCode=" + order.getSkuCode() + "&color=" + order.getColor() + "&size=" + order.getSize() )

                .collect(Collectors.joining("&"));
        

        // Check inventory for the given SKU codes, colors, and sizes
        InventoryResponseDto[] inventoryResponses;
        try {
            inventoryResponses = webClientBuilder.build().get()
                    .uri("http://localhost:8082/inventory?" + queryParams)
                    .retrieve()
                    .bodyToMono(InventoryResponseDto[].class)
                    .block();
        } catch (Exception e) {
            return "Error checking inventory: " + e.getMessage();
        }
        
//        System.out.println("Fetched Inventory Responses:");
//        if (inventoryResponses != null) {
//            for (InventoryResponseDto response : inventoryResponses) {
//                System.out.println("SKU: " + response.getSkuCode() + ", Color: " + response.getColor() + ", Size: " + response.getSize() + ", Quantity: " + response.getQuantity());
//            }
//        } else {
//            System.out.println("Inventory responses are null or empty.");
//        }

        if (inventoryResponses == null || inventoryResponses.length == 0) {
            return "Items not found in inventory!";
        }


        // Debug: Print inventory responses to verify its content
//        System.out.println("Inventory Responses:");
//        for (InventoryResponseDto response : inventoryResponses) {
//            System.out.println("SKU: " + response.getSkuCode() + ", Color: " + response.getColor() + ", Size: " + response.getSize() + ", Quantity: " + response.getQuantity());
//        }
        // Map inventory responses by SKU code, color, and size for easy lookup
        Map<String, InventoryResponseDto> inventoryMap = Arrays.stream(inventoryResponses)
            .collect(Collectors.toMap(
                response -> response.getSkuCode() + "|" + response.getColor() + "|" + response.getSize(),
                response -> response
            ));

        // Debug: Print inventory map to verify its content
        System.out.println("Inventory Map:");
        inventoryMap.forEach((key, value) -> {
            System.out.println(key + ": " + value.getQuantity());
        });

        StringBuilder errorMessages = new StringBuilder();
        boolean allOrdersPlaced = true;

        // Track inventory levels for adjustments
        Map<String, Integer> inventoryLevels = new HashMap<>();
        for (InventoryResponseDto response : inventoryResponses) {
            String key = response.getSkuCode() + "|" + response.getColor() + "|" + response.getSize();
            inventoryLevels.put(key, response.getQuantity());
        }

        // Debug: Print initial inventory levels
        System.out.println("Initial Inventory Levels:");
        inventoryLevels.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        // Validate stock and place orders
        for (OrderRequestDto orderRequest : orderRequests) {
            String key = orderRequest.getSkuCode() + "|" + orderRequest.getColor() + "|" + orderRequest.getSize();
            InventoryResponseDto inventoryResponse = inventoryMap.get(key);

            // Debug: Print key and inventoryResponse
            System.out.println("Checking order for key: " + key);
            if (inventoryResponse != null) {
                System.out.println("Inventory Response Quantity: " + inventoryResponse.getQuantity());
            }

            if (inventoryResponse == null) {
                // Check if SKU code exists but not the specified color and size
                boolean skuExists = inventoryMap.keySet().stream().anyMatch(k -> k.startsWith(orderRequest.getSkuCode()));
                boolean colorExists = inventoryMap.keySet().stream().anyMatch(k -> k.startsWith(orderRequest.getSkuCode() + "|" + orderRequest.getColor()));
                boolean sizeExists = inventoryMap.keySet().stream().anyMatch(k -> k.startsWith(orderRequest.getSkuCode() + "|" + orderRequest.getColor() + "|") && k.endsWith("|" + orderRequest.getSize()));

                if (!skuExists) {
                    errorMessages.append("Item with SKU code ").append(orderRequest.getSkuCode()).append(" not found in inventory! ");
                } else if (!colorExists) {
                    errorMessages.append("Item with SKU code ").append(orderRequest.getSkuCode()).append(" but color ").append(orderRequest.getColor()).append(" not found in inventory! ");
                } else if (!sizeExists) {
                    errorMessages.append("Item with SKU code ").append(orderRequest.getSkuCode()).append(" and color ").append(orderRequest.getColor()).append(" but size ").append(orderRequest.getSize()).append(" not found in inventory! ");
                }
                allOrdersPlaced = false;
                continue;
            }

            int availableStock = inventoryLevels.getOrDefault(key, 0);
            System.out.println("Available stock for key " + key + ": " + availableStock);
            if (availableStock < orderRequest.getQuantity()) {  // Check if the requested quantity is in stock
                errorMessages.append("Insufficient stock for SKU code ").append(orderRequest.getSkuCode())
                    .append(", color ").append(orderRequest.getColor()).append(", size ").append(orderRequest.getSize())
                    .append("! Requested quantity: ").append(orderRequest.getQuantity()).append(", Available quantity: ").append(availableStock).append(". ");
                allOrdersPlaced = false;
                continue;
            }

            // Adjust inventory levels
            inventoryLevels.put(key, availableStock - orderRequest.getQuantity());

            // Place order if all conditions are met for each SKU code, color, and size
            Order order = new Order();
            order.setOrderId(OrderIdGenerator.generateUniqueOrderId());
            order.setSkuCode(orderRequest.getSkuCode());
            order.setColor(orderRequest.getColor());
            order.setSize(orderRequest.getSize());
            order.setQuantity(orderRequest.getQuantity());
            order.setUserEmail(email);
            orderRepository.save(order);
        }

        // Debug: Print final inventory levels to verify adjustments
        System.out.println("Final Inventory Levels:");
        inventoryLevels.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        if (allOrdersPlaced) {
            return "Order placed successfully for all items!";
        } else {
            return errorMessages.toString();
        }
    }
    
    
}
