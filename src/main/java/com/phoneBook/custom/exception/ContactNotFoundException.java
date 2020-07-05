package com.phoneBook.custom.exception;

public class ContactNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2134964173852992233L;
	
	public ContactNotFoundException(String message) {
		super(message);
	}
}
