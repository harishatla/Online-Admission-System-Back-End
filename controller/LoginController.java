package com.onlineadmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmission.entity.LoginEntity;
import com.onlineadmission.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public List<LoginEntity> getAllLogin(){
		return loginService.getAllLogin();
	}
	
	@GetMapping("/login/{loginId}")
	public LoginEntity getLogin(@PathVariable("loginId") int loginId) {
		return loginService.getLogin(loginId);
	}
	
	@PutMapping("/login")
	public LoginEntity updateLogin(@RequestBody LoginEntity login) {
		return loginService.updateLogin(login);
	}

}
