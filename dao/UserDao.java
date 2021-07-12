package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineadmission.entity.DAOUser;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	@Query("select u from DAOUser u where u.username=:username")
	DAOUser findByUsername(@Param("username")String username);
	
}
