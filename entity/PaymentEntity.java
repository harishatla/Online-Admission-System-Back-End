package com.onlineadmission.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="payment")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_ID")
	@SequenceGenerator(name="PAYMENT_ID",sequenceName="PAYMENT_SEQ",allocationSize=1)
	
	@Column(name="PAYMENT_ID")
	private int paymentId;
	
	@Column(name="PAYMENT_AMOUNT")
	private double paymentAmount;
	
	@Column(name="PAYMENT_DESCRIPTION")
	private String paymentDescription;
	
	@Column(name="PAYMENT_DATE")
	private LocalDate paymentDate;
	
	@Column(name="PAYMENT_STATUS")
	private String paymentStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "application_id")
	private ApplicationEntity applicationEntity;
	
	public PaymentEntity() {
		super();
	}

	public PaymentEntity(int paymentId, double paymentAmount, String paymentDescription, LocalDate paymentDate,
			String paymentStatus, ApplicationEntity applicationEntity) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentDescription = paymentDescription;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.applicationEntity = applicationEntity;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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

	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@Override
	public String toString() {
		return "PaymentEntity [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", paymentDescription="
				+ paymentDescription + ", paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus
				+ ", applicationEntity=" + applicationEntity + "]";
	}
	
	

}
