package com.onlineadmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.LoginJpaDao;
import com.onlineadmission.entity.LoginEntity;
import com.onlineadmission.exception.LoginNotFoundException;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginJpaDao loginJpaDao;

	@Override
	public List<LoginEntity> getAllLogin() {
		List<LoginEntity> allLogin = loginJpaDao.findAll();
		if(allLogin.isEmpty()) {
            throw new LoginNotFoundException("No LoginFound");
        }
		return allLogin;
	}

	@Override
	public LoginEntity getLogin(int loginId) {
		LoginEntity loginEntity = new LoginEntity();
		Optional<LoginEntity> result = loginJpaDao.findById(loginId);
		if(result.isPresent()) {
			 loginEntity =result.get();
		}
		 return loginEntity;
		 
	}

	@Override
	public LoginEntity updateLogin(LoginEntity updatedLogin) {
		return loginJpaDao.save(updatedLogin);
	}

}
