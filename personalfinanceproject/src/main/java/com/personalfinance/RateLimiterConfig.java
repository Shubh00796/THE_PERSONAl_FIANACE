package com.personalfinance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.personalfinance.entites.RateLimiter;

@Configuration
public class RateLimiterConfig {

    @Bean
    public RateLimiter rateLimiter() {
        return new RateLimiter();
    }
}