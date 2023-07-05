package com.jparce.miniBank.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jparce.miniBank.model.TransactionType;
import com.jparce.miniBank.model.UsersModel;
import com.jparce.miniBank.repository.UsersRepository;

import jakarta.transaction.Transaction;

@Service
@Transactional
public class TransactionService {
	
//	 	private final UsersRepository usersRepository;
//	    private final TransactionService transactionService;

	    
//	    public TransactionService(UsersRepository usersRepository, TransactionService transactionService) {
//	        this.usersRepository = usersRepository;
//	        this.transactionService = transactionService;
//	    }
//
//	    public void deposit(Long accountId, Double amount) {
//	    	UsersModel usersModel = getAccountById(accountId);
//	    	usersModel.deposit(amount);
//	        usersRepository.save(usersModel);
//
//	        Transaction transaction = new Transaction(accountId, amount, TransactionType.DEPOSIT);
//	        transactionService.createTransaction(transaction);
//	    }
//
//	    public void withdraw(Long accountId, BigDecimal amount) {
//	        Account account = getAccountById(accountId);
//	        account.withdraw(amount);
//	        usersRepository.save(account);
//
//	        Transaction transaction = new Transaction(accountId, amount, TransactionType.WITHDRAW);
//	        transactionService.createTransaction(transaction);
//	    }
//
//	    public void transfer(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
//	        Account sourceAccount = getAccountById(sourceAccountId);
//	        Account targetAccount = getAccountById(targetAccountId);
//
//	        sourceAccount.withdraw(amount);
//	        targetAccount.deposit(amount);
//
//	        usersRepository.save(sourceAccount);
//	        usersRepository.save(targetAccount);
//
//	        Transaction transaction = new Transaction(sourceAccountId, amount, TransactionType.TRANSFER, sourceAccountId, targetAccountId);
//	        transactionService.createTransaction(transaction);
//	    }
//
//	    private Account getAccountById(Long accountId) {
//	        return usersRepository.findById(accountId)
//	                .orElseThrow(() -> new NotFoundException("Account not found"));
//	    }

//		private UsersModel getAccountById(Long accountId) {
//			// TODO Auto-generated method stub
//			return null;
//		}
}
