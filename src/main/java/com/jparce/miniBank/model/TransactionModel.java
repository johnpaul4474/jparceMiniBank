package com.jparce.miniBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int transactionId;
	
	private Double amount;
	private String transactionType;
	private Integer accountId;
	private Integer sourceAccountId;
	private Integer targetAccountId;
	

//    @PrePersist
//    public void prePersist() {
//        if (transactionType == null) {
//        	transactionType = "Default Name";
//        }
//    }
}