package com.personalfinance.utils;

import java.util.UUID;

public class OrderIdGenerator {
    public static String generateUniqueOrderId() {
        UUID uuid = UUID.randomUUID();
        long timestamp = System.currentTimeMillis();
        return uuid.toString() + "-" + timestamp;
    }
}