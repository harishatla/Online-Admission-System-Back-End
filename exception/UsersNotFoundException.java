package com.onlineadmission.exception;

public class UsersNotFoundException extends RuntimeException {
	String message;
	public UsersNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
