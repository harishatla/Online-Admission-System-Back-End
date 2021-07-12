package com.onlineadmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmission.pojo.UsersPojo;
import com.onlineadmission.service.UsersService;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/users")
	public List<UsersPojo> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	@GetMapping("users/{userId}")
	public UsersPojo getUsers(@PathVariable("userId") int userId) {
		return usersService.getUsers(userId);
	}
	
	
	 

}
