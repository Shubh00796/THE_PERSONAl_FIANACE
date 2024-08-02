package com.personalfinance.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalfinance.entites.Account;
import com.personalfinance.entites.User;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Optional<Account> findByUserEmail(String userEmail);
    Account findByUser(User user);


}
