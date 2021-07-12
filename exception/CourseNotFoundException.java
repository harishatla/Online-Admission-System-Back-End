package com.onlineadmission.exception;

public class CourseNotFoundException  extends RuntimeException{
	String message;
	public CourseNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
