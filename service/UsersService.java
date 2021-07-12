package com.onlineadmission.service;

import java.util.List;

import com.onlineadmission.pojo.UsersPojo;

public interface UsersService {
		
		  	public List<UsersPojo> getAllUsers();
		    
		    public UsersPojo getUsers(int userId);
	}
