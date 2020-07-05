package com.phoneBook.custom.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.phoneBook.custom.exception.ContactNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ContactNotFoundException.class)
	public String handleContactNotFoundException(){
		return "customError";
	}
}
