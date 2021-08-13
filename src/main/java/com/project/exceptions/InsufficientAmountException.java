package com.project.exceptions;

@SuppressWarnings("serial")
public class InsufficientAmountException extends Exception{
	
	public String getMessage() {
		return "Insuffient balance to debit";
		
	}
	
}
