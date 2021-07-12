package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.UsersJpaDao;
import com.onlineadmission.entity.ApplicationEntity;
import com.onlineadmission.entity.LoginEntity;
import com.onlineadmission.entity.UsersEntity;
import com.onlineadmission.exception.UsersNotFoundException;
import com.onlineadmission.pojo.ApplicationPojo;
import com.onlineadmission.pojo.LoginPojo;
import com.onlineadmission.pojo.UsersPojo;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersJpaDao usersJpaDao;
	
	public UsersServiceImpl() {
		
	}
	
	
	@Override
	public List<UsersPojo> getAllUsers() {
		
		List<UsersEntity> allUsersEntity = usersJpaDao.findAll();
		List<UsersPojo> allUsersPojo = new ArrayList<>();
		UsersPojo usersPojo = new UsersPojo();
		
		for(UsersEntity usersEntity : allUsersEntity) {
			
			BeanUtils.copyProperties(usersEntity, usersPojo);
			allUsersPojo.add(usersPojo);
			
			 
			LoginEntity loginEntity =  usersEntity.getLoginEntity();
			LoginPojo loginPojo = new LoginPojo();
			BeanUtils.copyProperties(loginEntity, loginPojo);
			usersPojo.setLoginIdPojo(loginPojo);
			
			ApplicationEntity applicationEntity = usersEntity.getApplicationEntity();
			ApplicationPojo applicationPojo = new ApplicationPojo();
			BeanUtils.copyProperties(applicationEntity, applicationPojo);
			usersPojo.setApplicationPojo(applicationPojo);
			
			
		}
		allUsersPojo.add(usersPojo);
		if(allUsersPojo.isEmpty()) {
            throw new UsersNotFoundException("No Users Found");
        }
		return allUsersPojo;
	}


	
	@Override
	public UsersPojo getUsers(int userId) {
		 UsersEntity usersEntity = new UsersEntity();
		 UsersPojo usersPojo = new UsersPojo();
		 
		Optional<UsersEntity> result = usersJpaDao.findById(userId);
		if(result.isEmpty()) {
			throw new UsersNotFoundException("no users Found");
		}
		
		if(result.isPresent()) {
			
			ApplicationEntity applicationEntity = result.get().getApplicationEntity();
			ApplicationPojo applicationPojo = new ApplicationPojo();
			BeanUtils.copyProperties(applicationEntity, applicationPojo);
			usersPojo.setApplicationPojo(applicationPojo);
			
			LoginEntity loginEntity = result.get().getLoginEntity();
			LoginPojo loginpojo = new LoginPojo();
			BeanUtils.copyProperties(loginEntity, loginpojo);
			usersPojo.setLoginIdPojo(loginpojo);
			
			BeanUtils.copyProperties(result.get(), usersPojo);
			 
		}
		return usersPojo;
	}

	 

}
