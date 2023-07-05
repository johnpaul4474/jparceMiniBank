package com.jparce.miniBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jparce.miniBank.model.TransactionModel;


public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {

}
