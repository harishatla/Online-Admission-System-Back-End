package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmission.entity.LoginEntity;

@Repository
public interface LoginJpaDao extends JpaRepository<LoginEntity, Integer>{

	
	
	
	
}
