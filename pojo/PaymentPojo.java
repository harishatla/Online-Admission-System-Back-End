package com.onlineadmission.pojo;

import java.time.LocalDate;

public class PaymentPojo {
	
	private int paymentId;
	private int applicationId;
	private double paymentAmount;
	private String paymentDescription;
	private LocalDate paymentDate;
	private String paymentStatus;
	private ApplicationPojo applicationPojo;
	
	public PaymentPojo() {
		super();
	}

	public PaymentPojo(int paymentId, int applicationId, double paymentAmount, String paymentDescription,
			LocalDate paymentDate, String paymentStatus, ApplicationPojo applicationPojo) {
		super();
		this.paymentId = paymentId;
		this.applicationId = applicationId;
		this.paymentAmount = paymentAmount;
		this.paymentDescription = paymentDescription;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.applicationPojo = applicationPojo;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public ApplicationPojo getApplicationPojo() {
		return applicationPojo;
	}

	public void setApplicationPojo(ApplicationPojo applicationPojo) {
		this.applicationPojo = applicationPojo;
	}

	@Override
	public String toString() {
		return "PaymentPojo [paymentId=" + paymentId + ", applicationId=" + applicationId + ", paymentAmount="
				+ paymentAmount + ", paymentDescription=" + paymentDescription + ", paymentDate=" + paymentDate
				+ ", paymentStatus=" + paymentStatus + ", applicationPojo=" + applicationPojo + "]";
	}

}
