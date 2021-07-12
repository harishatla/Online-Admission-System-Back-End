package com.onlineadmission.exception;

public class ApplicationNotFoundException extends RuntimeException {

	String message;
	public ApplicationNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
