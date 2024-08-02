package com.personalfinance.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinance.dao.TransactionRepository;
import com.personalfinance.dao.UserDao;
import com.personalfinance.dto.TransactionDTO;
import com.personalfinance.dto.UserDto;
import com.personalfinance.entites.Transaction;
import com.personalfinance.entites.User;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserDao userRepository;

    @Override
    public Transaction createTransaction(TransactionDTO transactionDTO) {
        User user = userRepository.findByEmail(transactionDTO.getUserEmail());
        System.out.printf("DRO OBJECT", transactionDTO);
        System.out.printf("USER OBJECT", user);
        
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(new Date());
        transaction.setCategory(transactionDTO.getCategory());
        transaction.setUser(user);

        return transactionRepository.save(transaction);
    }

	@Override
	public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
	}
	public List<TransactionDTO> getTransactionByEmail(String email) {
        List<Transaction> transactions = transactionRepository.findByUserEmail(email);
        return transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setCategory(transaction.getCategory());
        dto.setDate(transaction.getDate());

        dto.setUserEmail(transaction.getUser().getEmail());
        

        User user = transaction.getUser();
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getPassword());
        dto.setUser(userDto);

        return dto;
    }
    
    @Override
    public List<TransactionDTO> listOfCategoriesByEmail(String email) {
        List<Transaction> transactions = transactionRepository.findByUserEmail(email);
        return listOfCategories(transactions);
    }
		
    public List<TransactionDTO> listOfCategories(List<Transaction> transactions) {
        List<TransactionDTO> dtoList = new ArrayList<>();
        
        for (Transaction transaction : transactions) {
            TransactionDTO dto = new TransactionDTO();
            dto.setUserEmail(transaction.getUser().getEmail());
            dto.setCategory(transaction.getCategory());
            dtoList.add(dto);
        }
        
        return dtoList;
    }

	
}
