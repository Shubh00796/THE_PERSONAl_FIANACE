package com.personalfinance.service;

import com.personalfinance.entites.User;

public interface Userservice {
    User saveUser(User user);

	User validateUser(String email, String password);
}
