package com.personalfinance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.AccountRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.AccountDTO;
import com.personalfinance.entites.Account;
import com.personalfinance.entites.User;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserDao userRepository;

    public Optional<Double> checkBalance(String userEmail) {
        return accountRepository.findByUserEmail(userEmail).map(Account::getBalance);
    }
//    public Account createOrUpdateAccount(AccountDTO accountDTO) {
//    	Optional<User> userOptional = Optional.of(userRepository.findByEmail(accountDTO.getUserEmail()));
//    	
//        if (!userOptional.isPresent()) {
//            throw new IllegalArgumentException("User not found");
//        }
//
//        User user = userOptional.get();
//        System.out.println("Email of the user: " + accountDTO.getUserEmail());
//
//        Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findByUser(user));
//        Account account;
//
//        if (accountOptional.isPresent()) {
//            // Update existing account balance
//            account = accountOptional.get();
//            account.setBalance(accountDTO.getBalance());
//        } else {
//            // Create new account
//            account = new Account();
//            account.setBalance(accountDTO.getBalance());
//            account.setUser(user);
//        }
//
//        return accountRepository.save(account);
//    }

    public Account createOrUpdateAccount(AccountDTO accountDTO) {
        User user = userRepository.findByEmail(accountDTO.getUserEmail());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        System.out.println("Email of the user: " + accountDTO.getUserEmail());

        Account account = accountRepository.findByUser(user);
        if (account != null) {
            // Update existing account balance
            account.setBalance(accountDTO.getBalance());
        } else {
            // Create new account
            account = new Account();
            account.setBalance(accountDTO.getBalance());
            account.setUser(user);
        }

        return accountRepository.save(account);
    }

	
}