package com.handleException;

public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
		super("Current User is Not found in our system...");
	}
	
	public UserNotFoundException(String Stringsnotfound) {
		super("String not found exception");
	}	
}
