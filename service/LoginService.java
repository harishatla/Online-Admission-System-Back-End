package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.entity.LoginEntity;

public interface LoginService {
	
	  	public List<LoginEntity> getAllLogin();
	    
	    public LoginEntity getLogin(int loginId);
	    
	    public LoginEntity updateLogin(LoginEntity updatedLogin);
}
