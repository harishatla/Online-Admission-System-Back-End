package com.onlineadmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineadmission.dao.PaymentJpaDao;
import com.onlineadmission.entity.ApplicationEntity;
import com.onlineadmission.entity.PaymentEntity;
import com.onlineadmission.exception.PaymentNotFoundException;
import com.onlineadmission.pojo.ApplicationPojo;
import com.onlineadmission.pojo.PaymentPojo;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentJpaDao paymentJpaDao;
	

	@Override
	public List<PaymentPojo> getAllPayments() {
		List<PaymentEntity> allPaymentEntity =paymentJpaDao.findAll();
		List<PaymentPojo> allPaymentPojo = new ArrayList<>();	
		for(PaymentEntity paymentEntity: allPaymentEntity) {
			PaymentPojo paymentPojo =new PaymentPojo();
			BeanUtils.copyProperties(paymentEntity, paymentPojo);
			
			ApplicationEntity applicationEntity =  paymentEntity.getApplicationEntity();
			ApplicationPojo applicationPojo = new ApplicationPojo();
			BeanUtils.copyProperties(applicationEntity, applicationPojo);
			paymentPojo.setApplicationPojo(applicationPojo);
			allPaymentPojo.add(paymentPojo);
		}
        if(allPaymentPojo.isEmpty()) {
            throw new PaymentNotFoundException("No Payment Found");
        }
        return allPaymentPojo;
	}
	
	@Override
	public PaymentPojo addPayment(PaymentPojo payment) {
		PaymentEntity paymentEntity = new PaymentEntity();
		PaymentPojo paymentPojo = new PaymentPojo();
		BeanUtils.copyProperties(payment, paymentEntity);
		paymentEntity=paymentJpaDao.save(paymentEntity);
		return  payment;
	}

	@Override
	public PaymentPojo getPayment(int paymentId) {
		PaymentPojo paymentPojo = new PaymentPojo();
		PaymentEntity paymentEntity= new PaymentEntity();
		Optional<PaymentEntity> result = paymentJpaDao.findById(paymentId);
		if(result.isPresent()) {
			ApplicationEntity applicationEntity =  result.get().getApplicationEntity();
			ApplicationPojo applicationPojo = new ApplicationPojo();
			BeanUtils.copyProperties(applicationEntity, applicationPojo);
			
			BeanUtils.copyProperties(result.get(), paymentPojo);
			paymentPojo.setApplicationPojo(applicationPojo);
			
		}
		return paymentPojo;
	}

	 

}
