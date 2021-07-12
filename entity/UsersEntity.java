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

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "users")
public class UsersEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id")
	@SequenceGenerator(name="user_id",sequenceName="USERS_SEQ",allocationSize=1)
	@Column(name = "user_id")
	private int userId;
	
	 
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	 
	@Column(name = "mobile_number")
	private String mobileNo;
	
	 
	@Column(name = "aadhaar_number")
	private String aadhaarNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_id")
	private LoginEntity loginEntity;

	@OneToOne
	@JoinColumn(name="application_id")
	private ApplicationEntity applicationEntity;
	
	public UsersEntity() {
		super();
		 
	}

	public UsersEntity(int userId, String firstName, String middleName, String lastName, String email, String mobileNo,
			String aadhaarNumber, LoginEntity loginEntity, ApplicationEntity applicationEntity) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.aadhaarNumber = aadhaarNumber;
		this.loginEntity = loginEntity;
		this.applicationEntity = applicationEntity;
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

	public LoginEntity getLoginEntity() {
		return loginEntity;
	}

	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}

	public ApplicationEntity getApplicationEntity() {
		return applicationEntity;
	}

	public void setApplicationEntity(ApplicationEntity applicationEntity) {
		this.applicationEntity = applicationEntity;
	}

	@Override
	public String toString() {
		return "UsersEntity [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", email=" + email + ", mobileNo=" + mobileNo + ", aadhaarNumber="
				+ aadhaarNumber + ", loginEntity=" + loginEntity + ", applicationEntity=" + applicationEntity + "]";
	}

	 
	
	

	
	
	
}
