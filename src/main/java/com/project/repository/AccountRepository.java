package com.project.repository;

public interface AccountRepository {
	

	boolean checks(String account);
	
	double balance(String account) ;
	void update(String ac_num,double ac_bal);
	
}
