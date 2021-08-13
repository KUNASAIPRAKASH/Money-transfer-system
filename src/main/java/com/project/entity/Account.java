package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account",schema="money_tranfer")
public class Account {
	
	@Id
	private String ac_num;
	private double ac_bal;
	

	public Account(String ac_num, Double ac_bal) {
		super();
		this.ac_num = ac_num;
		this.ac_bal = ac_bal;
		
		
	}
	
	public Account() {
		
	}
	
	
	public String getAc_num() {
		return ac_num;
	}
	public void setAc_num(String ac_num) {

		this.ac_num = ac_num;
	}
	public double getAc_Bal() {
		return ac_bal;
	}
	public void setAc_Balance(double ac_bal) {
		this.ac_bal = ac_bal;
		
	}

	@Override
	public String toString() {
		return "Account [ac_num=" + ac_num + ", balance=" + ac_bal + "]";
	}
	
}
