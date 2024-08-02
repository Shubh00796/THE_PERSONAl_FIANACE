package com.personalfinance.service;

import java.util.List;

import com.personalfinance.dto.TransactionDTO;
import com.personalfinance.entites.Categories;
import com.personalfinance.entites.Transaction;

public interface TransactionService {

	Transaction createTransaction(TransactionDTO transactionDTO);
	List<Transaction> getAllTransactions();
	List<TransactionDTO> getTransactionByEmail(String email);
	List<TransactionDTO> listOfCategories(List<Transaction> transactions);
	List<TransactionDTO> listOfCategoriesByEmail(String email);
}
