package com.personalfinance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.UserDao;
import com.personalfinance.entites.User;
import com.personalfinance.utils.PasswordUtil;

@Service
public class UserServideImpl implements Userservice {

	@Autowired
	private UserDao userRepo;

	@Override
	
	public User saveUser(User user) {
        String hashedPassword = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        String hashedconfermedPassword = PasswordUtil.hashPassword(user.getConfirmPassword());
        user.setConfirmPassword(hashedconfermedPassword);

		if (user.getPhoneNumber() == null || user.getPhoneNumber().trim().isEmpty()) {
			throw new IllegalArgumentException("Phone number cannot be null or empty");
		}
		return userRepo.save(user);
	}

	@Override
	public User validateUser(String email, String password) {
	    System.out.println("Validating user with email: " + email);
	    User user = userRepo.findByEmail(email);
	    if (user == null) {
	        System.out.println("User not found");
	        throw new IllegalArgumentException("User not found");
	    }

	    String storedPassword = user.getPassword();
	    
	    // Check if the stored password is plain text
	    if (!PasswordUtil.isHashed(storedPassword)) {
	        // Validate the plain text password
	        if (!storedPassword.equals(password)) {
	            System.out.println("Invalid password");
	            throw new IllegalArgumentException("Invalid password");
	        }
	        // If valid, hash the plain text password and update the user record
	        String hashedPassword = PasswordUtil.hashPassword(password);
	        user.setPassword(hashedPassword);
	        userRepo.save(user);
	        System.out.println("User validated successfully and password updated to hashed format");
	    } else {
	        if (!PasswordUtil.checkPassword(password, storedPassword)) {
	            System.out.println("Invalid password");
	            throw new IllegalArgumentException("Invalid password");
	        }
	        System.out.println("User validated successfully");
	    }

	    return user;
	}

}
