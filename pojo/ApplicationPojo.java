package com.onlineadmission.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ApplicationPojo {
	
	private int applicationId;
	@NotNull(message="Applicant name Should not be null")
	private String applicantFuLLName;
	private Date dateOfBrith;
	@NotNull(message="Please enter valid qualifications details")
	private String highestQualification;
	private double highestQualificationPercentage;
	private String email;
	private String applicationStatus;
	private CollegePojo collegePojo;
	private PaymentPojo paymentPojo;
	private AdmissionPojo admissionPojo;
	private ApplicationPojo applicationPojo;
	private CoursePojo coursePojo;
	private BranchPojo branchPojo;
	
	public ApplicationPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationPojo(int applicationId,
			@NotNull(message = "Applicant name Should not be null") String applicantFuLLName, Date dateOfBrith,
			@NotNull(message = "Please enter valid qualifications details") String highestQualification,
			double highestQualificationPercentage, String email, String applicationStatus, CollegePojo collegePojo,
			PaymentPojo paymentPojo, AdmissionPojo admissionPojo, ApplicationPojo applicationPojo,
			CoursePojo coursePojo, BranchPojo branchPojo) {
		super();
		this.applicationId = applicationId;
		this.applicantFuLLName = applicantFuLLName;
		this.dateOfBrith = dateOfBrith;
		this.highestQualification = highestQualification;
		this.highestQualificationPercentage = highestQualificationPercentage;
		this.email = email;
		this.applicationStatus = applicationStatus;
		this.collegePojo = collegePojo;
		this.paymentPojo = paymentPojo;
		this.admissionPojo = admissionPojo;
		this.applicationPojo = applicationPojo;
		this.coursePojo = coursePojo;
		this.branchPojo = branchPojo;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicantFuLLName() {
		return applicantFuLLName;
	}

	public void setApplicantFuLLName(String applicantFuLLName) {
		this.applicantFuLLName = applicantFuLLName;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public double getHighestQualificationPercentage() {
		return highestQualificationPercentage;
	}

	public void setHighestQualificationPercentage(double highestQualificationPercentage) {
		this.highestQualificationPercentage = highestQualificationPercentage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public CollegePojo getCollegePojo() {
		return collegePojo;
	}

	public void setCollegePojo(CollegePojo collegePojo) {
		this.collegePojo = collegePojo;
	}

	public PaymentPojo getPaymentPojo() {
		return paymentPojo;
	}

	public void setPaymentPojo(PaymentPojo paymentPojo) {
		this.paymentPojo = paymentPojo;
	}

	public AdmissionPojo getAdmissionPojo() {
		return admissionPojo;
	}

	public void setAdmissionPojo(AdmissionPojo admissionPojo) {
		this.admissionPojo = admissionPojo;
	}

	public ApplicationPojo getApplicationPojo() {
		return applicationPojo;
	}

	public void setApplicationPojo(ApplicationPojo applicationPojo) {
		this.applicationPojo = applicationPojo;
	}

	public CoursePojo getCoursePojo() {
		return coursePojo;
	}

	public void setCoursePojo(CoursePojo coursePojo) {
		this.coursePojo = coursePojo;
	}

	public BranchPojo getBranchPojo() {
		return branchPojo;
	}

	public void setBranchPojo(BranchPojo branchPojo) {
		this.branchPojo = branchPojo;
	}

	@Override
	public String toString() {
		return "ApplicationPojo [applicationId=" + applicationId + ", applicantFuLLName=" + applicantFuLLName
				+ ", dateOfBrith=" + dateOfBrith + ", highestQualification=" + highestQualification
				+ ", highestQualificationPercentage=" + highestQualificationPercentage + ", email=" + email
				+ ", applicationStatus=" + applicationStatus + ", collegePojo=" + collegePojo + ", paymentPojo="
				+ paymentPojo + ", admissionPojo=" + admissionPojo + ", applicationPojo=" + applicationPojo
				+ ", coursePojo=" + coursePojo + ", branchPojo=" + branchPojo + "]";
	}
	



	
}
