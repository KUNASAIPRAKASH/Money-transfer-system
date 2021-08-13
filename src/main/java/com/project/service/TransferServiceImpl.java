package com.project.service;


import java.util.Date;

import com.project.entity.Transaction;
import com.project.entity.TxnType;
import com.project.exceptions.InsufficientAmountException;
import com.project.exceptions.InvalidAccountDetailsException;
import com.project.repository.AccountRepository;
import com.project.repository.AccountRepositoryImpl;
import com.project.repository.TransactionRepository;
import com.project.repository.TransactionRepositoryImpl;

public class TransferServiceImpl implements TransferService{

	AccountRepository accountRepository;
	TransactionRepository transactionrepository;
	
	public TransferServiceImpl(AccountRepository accountRepository, TransactionRepository transactionrepository) {
		super();
		this.accountRepository = accountRepository;
		this.transactionrepository = transactionrepository;
	}

	@Override
	public void transfer(double amount, String from_ac, String to_ac) {
		// TODO Auto-generated method stub
		
		AccountRepository acRepository=new AccountRepositoryImpl();
		TransactionRepository transactionRepository=new TransactionRepositoryImpl();
		Transaction transaction= null;
		
		boolean flag;
		int count1=0;
		try {
			flag= acRepository.checks(from_ac);
			
			if(!flag) {
				count1=1;
				throw new InvalidAccountDetailsException();
			}
			
			
		    flag=acRepository.checks(to_ac);
		    if(!flag) {
		    	throw new InvalidAccountDetailsException();
		    }
			
		    if(acRepository.balance(from_ac)<amount) {
		    	throw new InsufficientAmountException();
		    }
		    
		    else {
		    	acRepository.update(from_ac, acRepository.balance(from_ac)-amount);
		    	transaction =new Transaction(from_ac,amount,TxnType.DEBIT,new Date());
		    	transactionRepository.save(transaction);
		    	acRepository.update(to_ac, acRepository.balance(to_ac)+amount);
		    	transaction =new Transaction(to_ac,amount,TxnType.CREDIT,new Date());	
		    	transactionRepository.save(transaction);
		    }
		    
		    
		}catch (InvalidAccountDetailsException e) {
			// TODO: handle exception
			if(count1==1) {
				System.out.println(e.getMessage()+from_ac);
			}
			else {
				System.out.println(e.getMessage()+to_ac);
			}
		}catch (InsufficientAmountException e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+from_ac);
			
		}
	}


}
