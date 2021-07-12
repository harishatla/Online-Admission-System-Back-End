package com.onlineadmission.exception;

public class LoginNotFoundException extends RuntimeException{
	String message;
	public LoginNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
