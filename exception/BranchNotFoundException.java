package com.onlineadmission.exception;

public class BranchNotFoundException  extends RuntimeException {
	String message;
	
    public BranchNotFoundException(String message)
    {
        this.message=message;
    }
   
    @Override
    public String getMessage()
    {
        return message;
    }
	
}
