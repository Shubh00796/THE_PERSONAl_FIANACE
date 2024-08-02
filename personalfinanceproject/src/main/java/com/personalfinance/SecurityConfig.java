package com.personalfinance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF protection
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/products/**").permitAll() // Allow access to /products/** endpoints without authentication
                    .anyRequest().authenticated() // Require authentication for any other requests
            )
            .formLogin(withDefaults())
            .httpBasic(withDefaults());
        
        return http.build();
    }
}
