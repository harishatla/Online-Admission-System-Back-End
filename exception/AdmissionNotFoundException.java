package com.onlineadmission.exception;

public class AdmissionNotFoundException extends RuntimeException {
	
	 
	private static final long serialVersionUID = 1L;
	String message;
    public AdmissionNotFoundException(String message)
    {
        this.message=message;
    }
   
    @Override
    public String getMessage()
    {
        return message;
    }
}
