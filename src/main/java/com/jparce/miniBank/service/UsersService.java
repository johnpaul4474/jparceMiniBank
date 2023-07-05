package com.jparce.miniBank.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jparce.miniBank.model.TransactionModel;
import com.jparce.miniBank.model.UsersModel;
import com.jparce.miniBank.repository.TransactionRepository;
import com.jparce.miniBank.repository.UsersRepository;

@Service
public class UsersService {

	
	private final UsersRepository usersRepository;
	private final ObjectMapper objectMapper;
	private final TransactionRepository transactionRepository;

	public UsersService(UsersRepository usersRepository, ObjectMapper objectMapper,TransactionRepository transactionRepository) {
		this.usersRepository = usersRepository;
		this.objectMapper = objectMapper;
		this.transactionRepository = transactionRepository;
	}

	public String getTotalUsers() {
		long count = usersRepository.count();
		
		Map<String, Long> countResult = new HashMap<>();
		countResult.put("totalCount", count);
		
		try {
            return objectMapper.writeValueAsString(countResult);
        } catch (Exception e) {
            // Handle JSON serialization exception
            e.printStackTrace();
            return null;
        }
	}
	
	public UsersModel deposit(Integer accountId, Double amount) throws NotFoundException {
		UsersModel userModel = usersRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException());
		
		Double newBalance = userModel.getBalance() + amount;
		userModel.setBalance(newBalance);
		
        TransactionModel transaction = new TransactionModel();
        transaction.setTransactionType("Deposit");
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
        System.out.println(transaction);
        
		return usersRepository.save(userModel);
		
	}
	
    public UsersModel withdraw(Integer accountId, Double amount) throws NotFoundException {
    	UsersModel userModel = usersRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException());

        Double newBalance = userModel.getBalance() - amount;
        userModel.setBalance(newBalance);

        TransactionModel transaction = new TransactionModel();
        transaction.setTransactionType("Withdraw");
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
        
        return usersRepository.save(userModel);
    }
    
    public void transfer(Integer sourceAccountId, Integer targetAccountId, Double amount) throws NotFoundException {
        UsersModel sourceAccount = usersRepository.findById(sourceAccountId)
                .orElseThrow(() -> new NotFoundException());

        UsersModel targetAccount = usersRepository.findById(targetAccountId)
                .orElseThrow(() -> new NotFoundException());

        Double sourceNewBalance = sourceAccount.getBalance() - amount;
        Double targetNewBalance = targetAccount.getBalance() +amount;

        sourceAccount.setBalance(sourceNewBalance);
        targetAccount.setBalance(targetNewBalance);

        TransactionModel transaction = new TransactionModel();
        transaction.setTransactionType("Transfer");
        transaction.setAccountId(sourceAccountId);
        transaction.setSourceAccountId(sourceAccountId);
        transaction.setTargetAccountId(targetAccountId);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        usersRepository.save(sourceAccount);
        usersRepository.save(targetAccount);
    }
}
