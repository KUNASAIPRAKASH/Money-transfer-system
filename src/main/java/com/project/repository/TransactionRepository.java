package com.project.repository;

//import java.sql.Timestamp;

import java.util.Date;

import java.util.List;

import com.project.entity.Transaction;
import com.project.entity.TxnType;

public interface TransactionRepository {
	
	void save(Transaction transaction);
	
	List<Transaction> getTransaction();
	
	List<Transaction> getTransactionByLimit(int limit);
	
	List<Transaction> getTransactionType(TxnType txnType);
	
	List<Transaction> getTransactions(String account,Date start_date, Date end_date);
}
