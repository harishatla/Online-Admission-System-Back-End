package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmission.entity.UsersEntity;

@Repository
public interface UsersJpaDao extends JpaRepository<UsersEntity, Integer>{

}
