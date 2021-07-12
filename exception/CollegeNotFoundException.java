package com.onlineadmission.exception;

public class CollegeNotFoundException extends RuntimeException {
	String message;
	public CollegeNotFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
