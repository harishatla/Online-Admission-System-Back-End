package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmission.entity.BranchEntity;

@Repository
public interface BranchJpaDao extends JpaRepository<BranchEntity, Integer>{

}
