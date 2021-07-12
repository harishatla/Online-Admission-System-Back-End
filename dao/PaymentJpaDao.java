package com.onlineadmission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.onlineadmission.entity.PaymentEntity;

@Repository
public interface PaymentJpaDao  extends JpaRepository<PaymentEntity, Integer>{

}
