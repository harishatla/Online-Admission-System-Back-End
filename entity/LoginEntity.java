package com.onlineadmission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "login")
public class LoginEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login_id")
	@SequenceGenerator(name="login_id", sequenceName="LOGIN_SEQ", allocationSize=1)
	@Column(name = "login_id")
	private int loginId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	public LoginEntity() {
		super();
	}
	public LoginEntity(int loginId, String password, String role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setUserId(int loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginEntity [loginId=" + loginId + ", password=" + password + ", role=" + role + "]";
	}
	
}
