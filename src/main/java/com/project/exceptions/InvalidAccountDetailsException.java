package com.project.exceptions;

@SuppressWarnings("serial")
public class InvalidAccountDetailsException extends Exception{
	
	public String getMessage() {
		return "Invalid account number Please Enter a valid account number";
	}

}
