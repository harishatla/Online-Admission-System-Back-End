package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.pojo.PaymentPojo;

public interface PaymentService {
	
	  public List<PaymentPojo> getAllPayments();
	  
	  public PaymentPojo addPayment(PaymentPojo payment);
	   
	  public PaymentPojo getPayment(int paymentId);
	    
	     
}
