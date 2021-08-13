package com.project.entity;

import java.util.Date;
//import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transfer" ,schema="money_tranfer")
public class Transaction {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trans_id;
	private double amount;
	private String account;
	private Date Date_time;
	private TxnType debit_or_credit;
	
	
	public Transaction(String account,double amount,TxnType debit_or_credit,Date date) {
		super();
		this.account=account;
		this.amount = amount;
		this.Date_time = date;
		this.debit_or_credit = debit_or_credit;
	}


	public Transaction() {
		
	}
	

	public int getTrans_id() {
		return trans_id;
	}


	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	
	
	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getDate_time() {
		return Date_time;
	}


	public void setDate_time(Date Date_time) {
		this.Date_time = Date_time;
	}


	public TxnType getDebit_or_credit() {
		return debit_or_credit;
	}


	public void setDebit_or_credit(TxnType debit_or_credit) {
		this.debit_or_credit = debit_or_credit;
	}


	@Override
	public String toString() {
		return "Transfer [trans_id=" + trans_id + ", amount=" + amount + ", date_time=" + Date_time
				+ ", debit_or_credit=" + debit_or_credit + "]";
	}
	
}


