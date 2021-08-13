package com.project.repository;

import javax.persistence.EntityManager;

import com.project.entity.Account;
import com.project.jpa.LocalEntityManageFactory;

public class AccountRepositoryImpl implements AccountRepository{

	@Override
	public boolean checks(String ac_num) {
		// TODO Auto-generated method stub
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Account ac=em.find(Account.class, ac_num);
		em.getTransaction().commit();
		em.close();
		
		if(ac==null) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public double balance(String ac_num) {
		// TODO Auto-generated method stub
		
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
	
		Account ac=em.find(Account.class,ac_num);
		double bal=ac.getAc_Bal();
		
		em.getTransaction().commit();
		em.close();
		
		return bal;
	}

	public void update(String ac_num, double ac_bal) {
		// TODO Auto-generated method stub
		
		EntityManager em=LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Account ac=em.find(Account.class, ac_num);
		ac.setAc_Balance(ac_bal);
		
		em.getTransaction().commit();
		em.close();
		
	}


	

}
