package com.onlineadmission.exception;

public class PaymentNotFoundException  extends RuntimeException {
	
	String message;
	
	 public PaymentNotFoundException(String message)
	    {
	        this.message=message;
	    }
	   
	    @Override
	    public String getMessage()
	    {
	        return message;
	    }
}
