package com.onlineadmission.pojo;

import javax.validation.constraints.NotNull;

public class UsersPojo {
	
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	@NotNull(message="please enter correct mobile number")
	private String mobileNo;
	private String aadhaarNumber;
	private LoginPojo loginIdPojo;
	private ApplicationPojo applicationPojo;
	 
	public UsersPojo() {
		super();
	}

	public UsersPojo(int userId, String firstName, String middleName, String lastName, String email, String mobileNo,
			String aadhaarNumber, LoginPojo loginIdPojo, ApplicationPojo applicationPojo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.aadhaarNumber = aadhaarNumber;
		this.loginIdPojo = loginIdPojo;
		this.applicationPojo = applicationPojo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public LoginPojo getLoginIdPojo() {
		return loginIdPojo;
	}

	public void setLoginIdPojo(LoginPojo loginIdPojo) {
		this.loginIdPojo = loginIdPojo;
	}

	public ApplicationPojo getApplicationPojo() {
		return applicationPojo;
	}

	public void setApplicationPojo(ApplicationPojo applicationPojo) {
		this.applicationPojo = applicationPojo;
	}

	@Override
	public String toString() {
		return "UsersPojo [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", mobileNo=" + mobileNo + ", aadhaarNumber=" + aadhaarNumber
				+ ", loginIdPojo=" + loginIdPojo + ", applicationPojo=" + applicationPojo + "]";
	}
	 
	
	
	

	 

	 
	
	
	
	
	

	 
}
