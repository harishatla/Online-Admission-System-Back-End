package com.onlineadmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmission.pojo.PaymentPojo;
import com.onlineadmission.service.PaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payments")
	public List<PaymentPojo> getAllPayments(){
		
		List<PaymentPojo> allPayments = paymentService.getAllPayments();
		return allPayments;
	}
	
	@PostMapping("/payments")
	public PaymentPojo addPayment(@RequestBody PaymentPojo payment) {
		return paymentService.addPayment(payment);
	}
	
	@GetMapping("/payments/{paymentId}")
	public PaymentPojo getPayment(@PathVariable("paymentId") int paymentId) {
		return paymentService.getPayment(paymentId);
	}

}
