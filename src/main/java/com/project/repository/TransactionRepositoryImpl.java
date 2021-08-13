package com.project.repository;

//import java.sql.Timestamp;
import java.util.List;

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.project.entity.Transaction;
import com.project.entity.TxnType;
import com.project.jpa.LocalEntityManageFactory;

public class TransactionRepositoryImpl implements TransactionRepository{

	
	@Override
	public void save(Transaction transaction) {
		// TODO Auto-generated method stub
	
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		em.persist(transaction);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getTransaction() {
		// TODO Auto-generated method stub
		
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> transactions=em.createQuery("from Transaction").getResultList();
		
		 
		em.getTransaction().commit();
		em.close();
		
		return transactions;
	}


	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactions(String account,Date start_date, Date end_date) {
		// TODO Auto-generated method stub
		
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> transactions= (List<Transaction>) em.createQuery("from Transaction where account =: account and date_time between :start_date and :end_date")
				.setParameter("account",account)
				.setParameter("start_date",start_date)
				.setParameter("end_date",end_date).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return transactions;
	}

	@Override
	public List<Transaction> getTransactionByLimit(int limit) {
		// TODO Auto-generated method stub
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		Query query=em.createQuery("from Transaction ");
		query.setFirstResult(10);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<Transaction> transactions=query.getResultList();
		em.close();
		return transactions;
	}

	public List<Transaction> getTransactionType(TxnType txnType) {
		// TODO Auto-generated method stub
		
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		Query query=em.createQuery("from Transaction where debit_or_credit =:txnType");
		query.setParameter("txnType",txnType);
		@SuppressWarnings("unchecked")
		List<Transaction> transactions=query.getResultList();
		em.close();
		return transactions;
		
		
	}

	
	
}
