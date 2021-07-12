package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineadmission.entity.AdmissionEntity;

@Repository
public interface AdmissionJpaDao extends  JpaRepository<AdmissionEntity, Integer>{

}
